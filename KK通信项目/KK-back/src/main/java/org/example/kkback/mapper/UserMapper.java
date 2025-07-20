package org.example.kkback.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.kkback.dao.User;

import java.util.List;

@Mapper
public interface UserMapper  {

    @Select("select * from user")
    List<User> selectAll();
//    登录
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(String username,String password);

    @Insert("insert into user(id,username,password,pic) values(#{id},#{username},#{password},#{pic})")
    boolean reg(String id,String username,String password,String pic);





}
