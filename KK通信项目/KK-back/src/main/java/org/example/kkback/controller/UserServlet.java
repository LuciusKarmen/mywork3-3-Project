package org.example.kkback.controller;

import org.example.kkback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserServlet {
    @Autowired
    private UserService userService;

    @RequestMapping("/selectAll")
    public void selectAll()
    {
        userService.selectAll();
    }

    @RequestMapping("/selectByName")
    public void selectByName(String name)
    {
        userService.selectByName(name);
    }
}
