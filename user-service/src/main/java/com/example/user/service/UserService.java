package com.example.user.service;

import com.example.user.VO.Department;
import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside the method UserService.saveUser...");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside the method UserService.getUserWithDepartment...");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        String departmentUrl = System.getenv().getOrDefault("DEPARTMENT_URL"
                , "http://localhost:9001/departments/");
        log.info("The Department URL: {}", departmentUrl);
        Department department =
                restTemplate.getForObject(departmentUrl + user.getDepartmentId()
                , Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
