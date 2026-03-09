package org.example.student_manager.service;

import org.example.student_manager.dao.StudentCourse;
import org.example.student_manager.mapper.StudentCourseMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {
    private final StudentCourseMapper studentCourseMapper;
    public StudentCourseService(StudentCourseMapper studentCourseMapper) {
        this.studentCourseMapper = studentCourseMapper;
    }
    public int add(StudentCourse studentCourse) {
        return studentCourseMapper.add(studentCourse);
    }



}
