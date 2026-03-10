package org.example.student_manager.service;

import org.example.student_manager.dao.Course;
import org.example.student_manager.dao.StudentCourse;
import org.example.student_manager.mapper.StudentCourseMapper;
import org.example.student_manager.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {
    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @Autowired
    private CourseMapper CourseMapper;
    public StudentCourseService(CourseMapper CourseMapper) {
        this.CourseMapper = CourseMapper;
    }
    public int add(StudentCourse studentCourse) {
        //UUID
        studentCourse.setId(java.util.UUID.randomUUID().toString());
        return studentCourseMapper.add(studentCourse);
    }
    //查到学生和课的关系生成课表
    public List<Course> queryByStudentId(String studentId) {
        List<StudentCourse> studentCourses = studentCourseMapper.findByStudentId(studentId);

        List<Course> courses = CourseMapper.findByCourseId(studentCourses.get(0).getCourseId());
        return courses;


    }
}
