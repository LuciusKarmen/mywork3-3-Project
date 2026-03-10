package org.example.student_manager.dao;

import lombok.Data;

@Data
public class Student {
    private String  id;
    private String name;
    private String password;
    private String sex;
    private String phone;
    private Integer age;
    private String email;

}
