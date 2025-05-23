package org.example.springboot.controller;

import org.example.springboot.mapper.UserMapper;
import org.example.springboot.pojo.user;
import org.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Usershow {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    //(～￣▽￣)～展示一下
    @RequestMapping("/showuser")
    public List<user> getAll(){
        return userMapper.getAll();
    }
    //登录
    @PostMapping("/loginuser")
    public  String checkUser(@RequestBody user user)
    {
        if(userService.checkUser(user.getUsername(), user.getUserpassword())){
            return "success";
        }
        else {
            return "fail";
        }
    }






}
