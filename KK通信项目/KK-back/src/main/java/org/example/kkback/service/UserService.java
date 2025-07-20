package org.example.kkback.service;


import lombok.Data;
import org.example.kkback.dao.User;
import org.example.kkback.mapper.UserMapper;
import org.example.kkback.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> selectAll()
    {
        return userMapper.selectAll();
    }



    public Result<User> login(String username,String password)
    {
        User user = userMapper.login(username,password);
        if(user==null)
        {
            return Result.error(400,"用户名或密码错误");
        }
        return Result.ok(user);
    }

}
