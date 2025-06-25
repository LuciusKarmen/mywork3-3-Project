package org.example.csdnb.mapper;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user where name={#name}")
    User getUser(String name);
    @Select("SELECT pic FROM user where name={#name}")
    String getUserPic(String name);

}
