package com.teknopar.springboot.demo.repository;

import com.teknopar.springboot.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserName(String userName);
}
