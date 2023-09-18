package com.app.testAuthSecurity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.testAuthSecurity.entity.Role;
import com.app.testAuthSecurity.entity.User;

public interface UserService extends UserDetailsService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String email);

    Optional<User> getUser(String email);

    List<User> getUsers();
    void iniTialUserTest();


}
