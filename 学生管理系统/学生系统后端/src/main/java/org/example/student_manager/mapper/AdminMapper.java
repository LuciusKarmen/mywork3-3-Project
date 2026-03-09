package org.example.student_manager.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.student_manager.dao.Admin;

import java.util.List;

@Mapper
public interface AdminMapper {

    //登录验证
    @Select("select * from admin where name = #{name} and password = #{password}")
    Admin login(String name, String password);

}
