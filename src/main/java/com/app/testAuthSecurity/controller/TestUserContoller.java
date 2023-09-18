package com.app.testAuthSecurity.controller;

import com.app.testAuthSecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apiTest")
public class TestUserContoller {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> saveUser(){
        userService.iniTialUserTest();
        return new ResponseEntity<>("Save success", HttpStatus.CREATED);
    }
}
