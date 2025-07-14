package org.example.kkback.service;


import org.example.kkback.dao.User;
import org.example.kkback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> selectAll()
    {
        return userMapper.selectAll();
    }

}
