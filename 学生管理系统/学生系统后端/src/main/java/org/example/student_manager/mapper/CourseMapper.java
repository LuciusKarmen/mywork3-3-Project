package org.example.student_manager.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.student_manager.dao.Course;
import org.example.student_manager.dao.Student;

import java.util.List;

@Mapper
public interface CourseMapper {


  @Insert("INSERT INTO Course (id, name, no, ddd, time, num, teacherId) VALUES (#{id},#{name}, #{no}, #{ddd}, #{time}, #{num}, #{teacherId})")
  int add(Course course);

  //  查询所有课程
  @Select("SELECT * FROM course")
  List<Course> findAll();

  // 根据教师 ID 查询课程
  @Select("SELECT * FROM course WHERE teacherId = #{teacherId}")
  List<Course> findByTeacherId(String teacherId);

  //根据课程Id得出课表
  @Select("SELECT * FROM course WHERE id = #{Id}")
  List<Course> findByCourseId(String Id);


















}
