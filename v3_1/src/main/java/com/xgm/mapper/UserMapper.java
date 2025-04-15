package com.xgm.mapper;

import com.xgm.pojo.User;

import java.util.List;

public interface UserMapper {
//UserMapper 是一个 MyBatis 的 Mapper 接口，定义了一个方法 selectBlog()，返回一个 List<User> 类型的结果
    List<User> selectBlog();


}
