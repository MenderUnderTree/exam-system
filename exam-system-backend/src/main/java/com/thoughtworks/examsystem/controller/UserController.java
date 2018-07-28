package com.thoughtworks.examsystem.controller;

import com.thoughtworks.examsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String checkUserInfo(String username, String password){
        return userService.checkUserInfo(username,password);
    }

}
