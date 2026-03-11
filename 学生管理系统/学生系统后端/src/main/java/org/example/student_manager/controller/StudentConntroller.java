package org.example.student_manager.controller;

import org.example.student_manager.dao.Student;
import org.example.student_manager.service.StudentService;
import org.example.student_manager.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentConntroller {
    private final StudentService studentService;

    public StudentConntroller(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/login")
    public Result<Student> login(@RequestParam String name,
                                 @RequestParam String password)
    {
        System.out.println(name+" "+password);
        Student student = studentService.studentLogin(name, password);

        if (student != null) {
            return Result.ok(student);
        } else {
            return Result.error(401, "用户名或密码错误");
        }

    }
    @RequestMapping("/querystudentAll")
    public Result<List<Student>> querystudentAll() {
        return Result.ok(studentService.queryAllStudent());
    }
}
