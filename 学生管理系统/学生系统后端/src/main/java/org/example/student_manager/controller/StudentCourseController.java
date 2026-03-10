package org.example.student_manager.controller;

import org.example.student_manager.dao.Course;
import org.example.student_manager.dao.StudentCourse;
import org.example.student_manager.mapper.CourseMapper;
import org.example.student_manager.mapper.StudentCourseMapper;
import org.example.student_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sc")
public class StudentCourseController {
    private final StudentCourseMapper studentCourseMapper;
    public StudentCourseController(StudentCourseMapper studentCourseMapper) {
        this.studentCourseMapper = studentCourseMapper;
    }
    @Autowired
    private CourseMapper CourseMapper;
    @RequestMapping("/add")
    public Result<Integer> add(StudentCourse studentCourse) {
        return Result.ok(studentCourseMapper.add(studentCourse));
    }

    @RequestMapping("/queryByStudentId")
    public Result<List<Course>> queryByStudentId(String studentId) {
        return Result.ok(CourseMapper.findByCourseId(studentId));
    }



}
