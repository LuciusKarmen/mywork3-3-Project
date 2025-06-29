package org.example.csdnb.service;

import org.apache.catalina.User;
import org.example.csdnb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User getUser(String name) {
        return userMapper.getUser(name);
    }
    public String getPic(String name) {
        return userMapper.getUserPic(name);
    }
    public User login(String name, String password) {
        return userMapper.login(name, password);
    }

}
