package com.app.testAuthSecurity.repository;

import com.app.testAuthSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepo extends JpaRepository<User,Long> {
	User findByEmail(String email);

}
