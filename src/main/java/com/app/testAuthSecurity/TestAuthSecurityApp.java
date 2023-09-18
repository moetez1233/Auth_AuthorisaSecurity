package com.app.testAuthSecurity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.testAuthSecurity.entity.Role;
import com.app.testAuthSecurity.entity.User;
import com.app.testAuthSecurity.services.UserService;

@SpringBootApplication
public class TestAuthSecurityApp {

	public static void main(String[] args) {
		SpringApplication.run(TestAuthSecurityApp.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
