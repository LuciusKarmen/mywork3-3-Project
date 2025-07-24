package org.example.csdnb.controller;

import org.example.csdnb.dao.User;
import org.example.csdnb.service.UserService;
import org.example.csdnb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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



    @RequestMapping("/getUserPic/{name}")
    public Result<User> getUserPic(@PathVariable String name)
    {
        User user= userService.getUser(name);
        return Result.ok(user);
    }
    @RequestMapping("/login")
    public Result<User> login(@RequestParam String username,
                              @RequestParam String password
    ){
        if(userService.login(username,password)!=null)
        {
            User user=userService.login(username,password);
            return Result.ok(user);
        }
        return Result.error(400,"用户名或密码错误");


    }
    @RequestMapping("/register")
    public Result<String> register(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam MultipartFile pic
    ) throws IOException {


        if(userService.getUser(username)!=null) {
            return Result.error(400, "用户已存在");
        }else if(username.length()>10||password.length()>20){
            return Result.error(400, "用户名或密码过长");
        }else if(username.length()<4||password.length()<6){
            return Result.error(400, "用户名或密码过短");

        }
        else{
            userService.register(username,password,pic);
            return Result.ok();
        }


    }


}
