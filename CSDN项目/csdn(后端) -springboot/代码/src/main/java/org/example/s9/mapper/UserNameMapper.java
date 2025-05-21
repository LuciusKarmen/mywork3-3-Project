package org.example.s9.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.s9.pojo.user;

//Mapper XML不需要配置，直接在接口上使用注解即可
@Mapper
public interface UserNameMapper {
    @Select("select * from userdoro where name=#{name}")
    user getUserByName(String name);
    @Insert("insert into userdoro values(#{name},#{password},#{img},#{id}")
    void  addUser(user user);

}
