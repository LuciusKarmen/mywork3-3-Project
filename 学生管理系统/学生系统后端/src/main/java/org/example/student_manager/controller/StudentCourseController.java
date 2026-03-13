package org.example.student_manager.controller;

import org.apache.ibatis.annotations.Param;
import org.example.student_manager.dao.Course;
import org.example.student_manager.dao.StudentCourse;
import org.example.student_manager.mapper.CourseMapper;
import org.example.student_manager.mapper.StudentCourseMapper;
import org.example.student_manager.service.CourseService;
import org.example.student_manager.service.StudentCourseService;
import org.example.student_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sc")
public class StudentCourseController {
    private final StudentCourseMapper studentCourseMapper;
    @Autowired
    private StudentCourseService studentCourseService;
    @Autowired
    private CourseService CourseService;

    public StudentCourseController(StudentCourseMapper studentCourseMapper) {
        this.studentCourseMapper = studentCourseMapper;
    }
    @Autowired
    private CourseMapper CourseMapper;
    @RequestMapping("/add")
    public Result<Integer> add(@RequestBody StudentCourse studentCourse) {
        return Result.ok(studentCourseService.add(studentCourse));
    }

    @RequestMapping("/queryByStudentId")
    public Result<List<Course>> queryByStudentId(@Param( "studentId") String studentId) {
        System.out.println(studentCourseService.queryStudentId(studentId));
        return Result.ok(studentCourseService.queryStudentId(studentId));

    }

    //返回所有没有选的课程
// ... existing code ...
    @GetMapping("/queryno")
    public Result<List<Course>> getAvailableCourses(@RequestParam String studentId) {
        List<Course> allCourses = CourseService.queryAllCourse();
        List<Course> selectedCourses = studentCourseService.queryStudentId(studentId);
        Set<String> selectedCourseIds = selectedCourses.stream().map(Course::getId).collect(Collectors.toSet());
        System.out.println("hhh"+allCourses.stream()
                .filter(course -> !selectedCourseIds.contains(course.getId()))
                .collect(Collectors.toList()));

        return Result.ok(allCourses.stream()
                .filter(course -> !selectedCourseIds.contains(course.getId()))
                .collect(Collectors.toList()));
    }


    @RequestMapping("/querytable")
    public Result<List<Course>> queryStudentId(@Param( "studentId") String studentId) {
        return Result.ok(studentCourseService.queryStudentId(studentId));
    }




}
