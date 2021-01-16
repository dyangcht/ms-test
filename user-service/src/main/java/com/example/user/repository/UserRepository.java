package com.example.user.repository;

import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    User findByUserId(Long userId);
}
