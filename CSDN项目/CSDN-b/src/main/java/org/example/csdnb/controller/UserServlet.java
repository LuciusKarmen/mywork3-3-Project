package org.example.csdnb.controller;

import org.example.csdnb.dao.User;
import org.example.csdnb.service.UserService;
import org.example.csdnb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


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
        return Result.ok((User) userService.login(name,password));
    }
    @RequestMapping("/register")
    public Result<String> register(
            @RequestParam String name,
            @RequestParam String password,
            @RequestParam MultipartFile pic
    ) throws IOException {


        if(userService.getUser(name)!=null) {
            return Result.error(400, "用户已存在");
        }else if(name.length()>10||password.length()>20){
            return Result.error(400, "用户名或密码过长");
        }else if(name.length()<4||password.length()<6){
            return Result.error(400, "用户名或密码过短");

        }
        else{
            userService.register(name,password,pic);
            return Result.ok("注册成功");
        }


    }


}
