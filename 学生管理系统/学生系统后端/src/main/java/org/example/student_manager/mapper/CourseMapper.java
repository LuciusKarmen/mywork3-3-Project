package org.example.student_manager.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.student_manager.dao.Course;

@Mapper
public interface CourseMapper {

  @Insert("INSERT INTO student (id, name, no, describe, time, num, teacher_id) VALUES (#{id},#{name}, #{no}, #{describe}, #{time}, #{num}, #{teacherId})")
  int add(Course course);


}
