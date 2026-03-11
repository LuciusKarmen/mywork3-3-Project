package org.example.student_manager.controller;

import org.example.student_manager.dao.Teacher;
import org.example.student_manager.service.TeacherService;
import org.example.student_manager.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @RequestMapping("/login")
    public Result<Teacher> login(@RequestParam String name,
                                 @RequestParam String password)
    {
        System.out.println(name+" "+password);
        Teacher teacher = teacherService.login(name, password);

        if (teacher != null) {
            return Result.ok(teacher);
        } else {
            return Result.error(401, "用户名或密码错误");
        }

    }
    @RequestMapping("/queryteacherAll")
    public Result<List<Teacher>> queryAll() {
        return Result.ok(teacherService.queryAllTeacher());
    }
}
