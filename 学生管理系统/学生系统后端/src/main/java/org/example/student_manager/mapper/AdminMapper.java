package org.example.student_manager.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.student_manager.dao.Admin;
import org.example.student_manager.dao.Student;
import org.example.student_manager.dao.Teacher;

import java.util.List;

@Mapper
public interface AdminMapper {

    //登录验证
    @Select("select * from admin where name = #{name} and password = #{password}")
    Admin login(String name, String password);
    //添加老师
    @Insert("insert into teacher(id, name, password, sex, phone, email, position, department) values(#{id}, #{name}, #{password}, #{sex}, #{phone}, #{email}, #{position}, #{department})")
    int addTeacher(Teacher teacher);

    //添加学生
    @Insert("insert into student(id, name, password, sex, phone, age, email) values(#{id}, #{name}, #{password}, #{sex}, #{phone}, #{age}, #{email})")
    int addStudent(Student student);

    //同意课程
    @Update("update course set no = 1 where id = #{courseId}")
    int agreeCourse(@Param("courseId") String courseId);

}
