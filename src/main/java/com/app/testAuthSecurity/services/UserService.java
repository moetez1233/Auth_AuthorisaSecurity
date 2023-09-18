package com.app.testAuthSecurity.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.testAuthSecurity.entity.Role;
import com.app.testAuthSecurity.entity.User;

public interface UserService extends UserDetailsService  {
	User saveUser(User user);
	Role saveRole(Role role);
void addRoleToUser(String email);

	User getUser(String email);
	List<User> getUsers(); 
	

}
