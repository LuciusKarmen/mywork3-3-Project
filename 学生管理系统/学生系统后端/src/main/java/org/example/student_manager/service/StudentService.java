package org.example.student_manager.service;

import org.example.student_manager.dao.Student;
import org.example.student_manager.mapper.StudentMapper;
import org.example.student_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;


    public Student studentLogin( String name, String password){
        return  studentMapper.login(name,password);
    }


}
