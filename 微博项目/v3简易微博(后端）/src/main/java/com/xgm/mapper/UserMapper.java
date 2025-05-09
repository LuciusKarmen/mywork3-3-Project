package com.xgm.mapper;

import com.xgm.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
//UserMapper 是一个 MyBatis 的 Mapper 接口，定义了一个方法 selectBlog()，返回一个 List<User> 类型的结果
    List<User> selectBlog();

    @Insert("insert into user (name,password) VALUES(#{name},#{password})")
    void add(User user);

    @Select("select *from user where name=#{name}")
    User getUser(String name);

}
