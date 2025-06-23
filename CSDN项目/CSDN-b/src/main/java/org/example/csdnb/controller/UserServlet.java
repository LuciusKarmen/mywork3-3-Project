package org.example.csdnb.controller;

import org.apache.catalina.User;
import org.example.csdnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserServlet {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUser")
    public User getUser(String name)
    {
        return userService.getUser(name);
    }

}
