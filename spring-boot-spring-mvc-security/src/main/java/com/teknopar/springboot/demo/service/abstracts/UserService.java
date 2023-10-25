package com.teknopar.springboot.demo.service.abstracts;

import com.teknopar.springboot.demo.model.User;
import com.teknopar.springboot.demo.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUserName(String userName);

    void save(WebUser webUser);

}
