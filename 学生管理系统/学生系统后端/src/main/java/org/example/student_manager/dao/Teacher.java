package org.example.student_manager.dao;

import lombok.Data;

@Data
public class Teacher {
    private String id;
    private String name;
    private String sex;
    private String password;
    private String phone;
    private String email;
    private String position;     // 职称
    private String department;   // 院系
}