package org.example.kkback.controller;

import org.example.kkback.dao.User;
import org.example.kkback.service.UserService;
import org.example.kkback.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    }
    @RequestMapping("/login")
    public Result<User> login(@RequestBody User user)
    {
        String username = user.getUsername();
        String password = user.getPassword();
        return userService.login(username,password);
    }

}
