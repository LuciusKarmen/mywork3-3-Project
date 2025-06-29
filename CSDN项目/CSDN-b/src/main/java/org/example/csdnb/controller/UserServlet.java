package org.example.csdnb.controller;

import org.apache.catalina.User;
import org.example.csdnb.service.UserService;
import org.example.csdnb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/user")
@RestController
public class UserServlet {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUserPic")
    public Result<String> getUserPic(String name)
    {
        return Result.ok(userService.getPic(name));
    }
    @RequestMapping("/login")
    public Result<User> login(String name, String password){
        return Result.ok(userService.login(name,password));
    }
    @RequestMapping("/register")
    public Result<String> register(
            @RequestParam String name,
            @RequestParam String password
    ){
        return Result.ok();
    }


}
