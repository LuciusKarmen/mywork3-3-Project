package org.example.springboot.service;

import org.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

        // 验证用户是否存在

        public boolean checkUser(String username, String password) {
            return userMapper.loginuser(username, password) != null;
        }



}
