package org.example.student_manager.service;

import org.example.student_manager.dao.Teacher;
import org.example.student_manager.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherMapper teacherMapper;
    public TeacherService(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }
    public Teacher login(String name, String password) {
        return teacherMapper.login(name, password);
    }
}
