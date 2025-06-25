package org.example.csdnb.controller;

import org.example.csdnb.service.UserService;
import org.example.csdnb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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


}
