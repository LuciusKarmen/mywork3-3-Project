package org.example.student_manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.student_manager.dao.Teacher;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where name = #{name} and password = #{password}")
    Teacher login(String name, String password);

    @Select("select * from teacher")
    List<Teacher> findAll();

}
