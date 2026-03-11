package org.example.student_manager.controller;

import org.example.student_manager.dao.Course;
import org.example.student_manager.service.CourseService;
import org.example.student_manager.utils.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @RequestMapping("/queryCourseAll")
    public Result<List<Course>>  queryCourseAll() {
        return Result.ok(courseService.queryAllCourse());
    }
    @RequestMapping("/queryCourseByTeacherId")
    public Result<List<Course>> queryCourseByTeacherId(@RequestParam String teacherId) {
        return Result.ok(courseService.queryCourseByTeacherId(teacherId));
    }

    //添加课程
    @RequestMapping("/addCourse")
    public Result<Integer> addCourse(@RequestBody Course course) {
        return Result.ok(courseService.add(course));
    }



}
