package org.example.student_manager.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.student_manager.dao.StudentCourse;

import java.util.List;

@Mapper
public interface StudentCourseMapper {

    @Insert("insert into student_course(id, no, studentId, courseId) values(#{id},#{no}, #{studentId}, #{courseId})")
    int add(StudentCourse studentCourse);

    @Select("select * from student_course where studentId = #{studentId}")
    List<StudentCourse> findByStudentId(String studentId);


    @Insert("DELETE FROM student_course WHERE studentId = #{studentId}")
    int deleteByStudentId(String studentId);


    @Delete("DELETE FROM student_course WHERE courseId = #{courseId}")
    int deleteByCourseId(String courseId);




}
