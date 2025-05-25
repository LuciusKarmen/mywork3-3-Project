package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.example.springboot.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<user> getAll();

    @Select("select * from user where username=#{username} AND userpassword=#{userpassword}")
    user loginuser(String username,String userpassword);

    @Insert("insert into user(userid,username,userpassword,userpath) values(#{userid},#{username},#{userpassword},#{userpath})")
    boolean insert(String userid,String username,String userpassword,String userpath);

}
