package org.example.kkback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.kkback.dao.User;

import java.util.List;


public interface UserMapper{

    @Insert("select * from user where name=#{name}")
    User selectByName(String name);
    @Insert("select * from user")
    List<User> selectAll();
}
