package com.example.jpademo.controller;

import com.example.jpademo.Service.UserService;
import com.example.jpademo.domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findAll();
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public User postUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @ApiOperation(value = "获取用户信息", notes = "根据用户的名字获取用户信息")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable("username") String username) {
        return userService.findUserByName(username);
    }

//    @ApiOperation(value = "获取用户信息", notes = "根据用户的id获取用户信息")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public User getUser(@PathVariable long id) {
//        return userService.findUserById(id);
//    }

    @ApiOperation(value = "更新用户信息", notes = "根据URL的id指定更新用户信息")
    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    public User putUser(@PathVariable("username") String username, @RequestBody User user) {
        User originUser = userService.findUserByName(username);
        originUser.setUsername(user.getUsername());
        originUser.setPassword(user.getPassword());
        return userService.updateUser(originUser);
    }

    @ApiOperation(value = "删除用户信息", notes = "根据URL的id删除指定用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "success";
    }

    @ApiIgnore
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String jsonTest() {
        return "hi you";
    }
}
