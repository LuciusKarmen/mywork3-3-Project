package org.example.student_manager.controller;

import org.example.student_manager.dao.Admin;
import org.example.student_manager.service.AdminService;
import org.example.student_manager.utils.Result;

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
    public Result<Admin> login(@RequestParam String name,
                               @RequestParam String password)
    {
        System.out.println(name+" "+password);
        Admin admin = adminService.login(name, password);

        if (admin != null) {
            return Result.ok(admin); // 登录成功
        } else {
            return Result.error(401, "用户名或密码错误"); // 登录失败
        }

    }
}
