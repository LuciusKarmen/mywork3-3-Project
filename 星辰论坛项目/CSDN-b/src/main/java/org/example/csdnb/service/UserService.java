package org.example.csdnb.service;

import org.example.csdnb.dao.User;
import org.example.csdnb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    private static final String UPLOAD_DIR = "C:/path/to/CSDN";
    public User getUser(String name) {
        return userMapper.getUser(name);
    }
    public String getPic(String name) {
        return userMapper.getUserPic(name);
    }
    public User login(String name, String password) {
        return userMapper.login(name,password);
    }
    public void register(String name, String password, MultipartFile pic) throws IOException {
        String id= UUID.randomUUID().toString() ;

        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = id + "_" +pic.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);


        String dbPath = "CSDN/" + fileName;

        pic.transferTo(filePath.toFile());


        userMapper.register(id, name, password, pic.getOriginalFilename());
    }

}
