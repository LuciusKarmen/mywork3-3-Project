package org.example.student_manager.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.student_manager.dao.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student where id = #{id}")
    Student findById(String id);

    @Select("select * from student where name = #{name}")
    Student findByName(String name);

    @Select("select * from student")
    List<Student> findAll();

    @Insert("insert into student(id, name, password, sex, phone, age, email) values(#{id}, #{name}, #{password}, #{sex}, #{phone}, #{age}, #{email})")
    int add(Student student);

   @Update("update student set name = #{name}, sex = #{sex}, phone = #{phone}, age = #{age}, email = #{email} where id = #{id}")
    int update(Student student);

   //登录验证
    @Select("select * from student where name = #{name} and password = #{password}")
    Student login(String name, String password);

}
