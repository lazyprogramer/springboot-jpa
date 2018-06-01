package com.example.jpademo.controller;

import com.example.jpademo.Service.UserService;
import com.example.jpademo.domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "获取用户信息", notes = "根据用户的名字获取用户信息")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
//    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.findUserByName(username);
    }
}
