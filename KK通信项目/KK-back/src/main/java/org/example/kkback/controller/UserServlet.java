package org.example.kkback.controller;

import org.example.kkback.dao.User;
import org.example.kkback.service.UserService;
import org.example.kkback.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public Result<User> login(@RequestParam String username,
                              @RequestParam String password)
    {
        System.out.println(username+" "+password);
        return userService.login(username,password);
    }
    @RequestMapping("/reg")
    public Result<String> reg(@RequestParam String name,
                      @RequestParam String password,
                      @RequestParam MultipartFile pic
    ) throws Exception
    {
        userService.register(name,password,pic);
        return Result.ok();
    }


}
