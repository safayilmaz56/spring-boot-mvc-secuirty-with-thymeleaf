package com.teknopar.springboot.demo.service.concretes;

import com.teknopar.springboot.demo.model.Role;
import com.teknopar.springboot.demo.model.User;
import com.teknopar.springboot.demo.repository.RoleRepository;
import com.teknopar.springboot.demo.repository.UserRepository;
import com.teknopar.springboot.demo.service.abstracts.UserService;
import com.teknopar.springboot.demo.user.WebUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public User findByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }
    @Override
    public void save(WebUser webUser) {
        User user = new User();

        user.setUserName(webUser.getUserName());
        user.setPassword(passwordEncoder.encode(webUser.getPassword()));
        user.setFirstName(webUser.getFirstName());
        user.setLastName(webUser.getLastName());
        user.setEmail(webUser.getEmail());

        user.setRoles(Arrays.asList(roleRepository.findRoleByName("ROLE_EMPLOYEE")));

        userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        List<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(user.getRoles());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),authorities);
    }
    private List<SimpleGrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role tempRole : roles) {
            SimpleGrantedAuthority tempAuthority = new SimpleGrantedAuthority(tempRole.getName());
            authorities.add(tempAuthority);
        }
        return authorities;
    }
}

