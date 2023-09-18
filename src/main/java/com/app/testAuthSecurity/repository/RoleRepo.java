package com.app.testAuthSecurity.repository;

import java.util.List;

import com.app.testAuthSecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepo extends JpaRepository<Role,Long> {
	List<Role> findRoleById(String id);

}
