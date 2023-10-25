package com.teknopar.springboot.demo.repository;

import com.teknopar.springboot.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByName(String theRoleName);
}
