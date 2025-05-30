package org.example.springboot.controller;

import org.example.springboot.config.Result;
import org.example.springboot.mapper.UserMapper;
import org.example.springboot.pojo.User;
import org.example.springboot.service.UserService;
import org.example.springboot.utils.JWTUTIL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class Usershow {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    User usera = new User();

    private static final String UPLOAD_DIR = "C:/path/to/uploads";

    //(～￣▽￣)～展示一下
    @RequestMapping("/showuser")
    public List<User> getAll(){
        return userMapper.getAll();
    }
    //登录
    @PostMapping("/loginuser")
    public Result<String> checkUser(@RequestBody User user)
    {
        if(userService.checkUser(user.getUsername(), user.getUserpassword())){
            Map<String,Object> claims = new HashMap<>();
            claims.put("username",user.getUsername());
            String token = JWTUTIL.genToken(claims);
            return Result.success(token);
        }
        else {

            return Result.error(400,"用户名或密码错误");
        }
    }
    @PostMapping("/registeruser")
    public String insertUser(
            @RequestParam("userid") String userid,
            @RequestParam("username") String username,
            @RequestParam("userpassword") String userpassword,
            @RequestParam("userfile") MultipartFile file
    ) throws IOException {

        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);


        String dbPath = "uploads/" + fileName;

        userMapper.insert(userid, username, userpassword, dbPath);
        file.transferTo(filePath.toFile());

        return "success";
    }
}
