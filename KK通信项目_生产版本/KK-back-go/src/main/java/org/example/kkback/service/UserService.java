package org.example.kkback.service;


import org.example.kkback.dao.User;
import org.example.kkback.mapper.UserMapper;
import org.example.kkback.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    private static final String UPLOAD_DIR = "/home/path/to/KK";
    public List<User> selectAll()
    {
        return userMapper.selectAll();
    }
    public User selectById(String id)
    {
        return userMapper.selectById(id);
    }
    public Result<User> login(String username, String password)
    {
        User user = userMapper.login(username,password);
        if(user==null)
        {
            return Result.error(400,"用户名或密码错误");
        }
        return Result.ok(user);
    }
    public void register(String name, String password, MultipartFile pic) throws IOException {
        String id= UUID.randomUUID().toString() ;

        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = id + "_" +pic.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);


        String dbPath = "KK/" + fileName;

        pic.transferTo(filePath.toFile());


        userMapper.reg(id, name, password, dbPath);
    }
    public User selectnew(String name)
    {
        return userMapper.selectnew(name);
    }

}
