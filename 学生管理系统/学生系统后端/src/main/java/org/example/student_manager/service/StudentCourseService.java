package org.example.student_manager.service;

import org.example.student_manager.dao.Course;
import org.example.student_manager.dao.StudentCourse;
import org.example.student_manager.mapper.StudentCourseMapper;
import org.example.student_manager.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentCourseService {
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    @Autowired
    private CourseMapper courseMapper;

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
    //ID查询其所有选课关系
    public List<Course> queryStudentId(String studentId) {
        // 1. 根据学生ID查询其所有选课关系
        List<StudentCourse> studentCourses = studentCourseMapper.findByStudentId(studentId);
        System.out.println(studentCourses);

        if (studentCourses == null || studentCourses.isEmpty()) {
            return new ArrayList<>(); // 没有选课记录，返回空列表
        }

        // 2. 遍历每条选课记录，用 courseId 查询对应的课程详情
        List<Course> courses = new ArrayList<>();
        for (StudentCourse sc : studentCourses) {
            String courseId = sc.getCourseId();
            if (courseId != null) {
                Course course = courseMapper.findByCourseId(courseId);
                if (course != null) {
                    courses.add(course);
                }
            }

        }
        System.out.println(courses);

        return courses;
    }
}
