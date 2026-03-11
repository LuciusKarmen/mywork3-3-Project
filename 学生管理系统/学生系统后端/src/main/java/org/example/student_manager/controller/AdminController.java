package org.example.student_manager.controller;

import org.example.student_manager.dao.Admin;
import org.example.student_manager.dao.Student;
import org.example.student_manager.dao.Teacher;
import org.example.student_manager.service.AdminService;
import org.example.student_manager.utils.Result;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/login")
    public Result<String> login(@RequestParam String name,
                               @RequestParam String password)
    {

        Admin admin = adminService.login(name, password);

        if (admin != null) {
            return Result.ok(); // 登录成功
        } else {
            return Result.error(401, "用户名或密码错误"); // 登录失败
        }

    }
    @RequestMapping("/addTeacher")
    public Result<Integer> addTeacher(@RequestBody Teacher teacher) {
        return Result.ok(adminService.addTeacher(teacher));
    }
    @RequestMapping("/addStudent")
    public Result<Integer> addStudent(@RequestBody Student student) {
        return Result.ok(adminService.addStudent(student));
    }
    @RequestMapping("/agreeCourse")
    public Result<Integer> agreeCourse(@RequestParam String id) {
        return Result.ok(adminService.agreeCourse(id));
    }
}
