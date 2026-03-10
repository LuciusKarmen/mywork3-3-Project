package org.example.student_manager.service;

import org.example.student_manager.dao.Course;
import org.example.student_manager.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseMapper courseMapper;
    public CourseService(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }
    public List<Course> queryCourseByTeacherId(String teacherId) {
        return courseMapper.findByTeacherId(teacherId);
    }

    public List<Course> queryAllCourse() {

        return courseMapper.findAll();
    }

    public int add(Course course) {
        course.setId(java.util.UUID.randomUUID().toString());
        return courseMapper.add(course);
    }
}
