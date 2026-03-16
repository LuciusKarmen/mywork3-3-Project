package org.example.student_manager.service;

import org.example.student_manager.dao.Teacher;
import org.example.student_manager.mapper.CourseMapper;
import org.example.student_manager.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherMapper teacherMapper;
    public TeacherService(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }
    public Teacher login(String name, String password) {
        return teacherMapper.login(name, password);
    }

    public List<Teacher> queryAllTeacher() {
        return teacherMapper.findAll();
    }

    //删除老师
    @Autowired
    private CourseMapper courseMapper;
    public int deleteTeacher(String id) {
        courseMapper.deleteByTeacherId(id);
        return teacherMapper.delete(id);
    }
}
