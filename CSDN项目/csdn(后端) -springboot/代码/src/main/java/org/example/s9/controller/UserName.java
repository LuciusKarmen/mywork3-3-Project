package org.example.s9.controller;

import org.example.s9.mapper.UserNameMapper;
import org.example.s9.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserName {
    @Autowired
    private UserNameMapper userNameMapper;
    //实现类
    @RequestMapping("/get")
    public user getUserMessage(String name){
        return userNameMapper.getUserByName(name);
    }

}
