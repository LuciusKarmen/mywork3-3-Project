package org.example.kkback.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.kkback.dao.User;

import java.util.List;

@Mapper
public interface UserMapper  {

    @Select("select * from user")
    List<User> selectAll();

}
