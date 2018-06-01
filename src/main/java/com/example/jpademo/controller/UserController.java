package com.example.jpademo.controller;

import com.example.jpademo.Service.UserService;
import com.example.jpademo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username")String username){
        return userService.findUserByName(username);
    }
}
