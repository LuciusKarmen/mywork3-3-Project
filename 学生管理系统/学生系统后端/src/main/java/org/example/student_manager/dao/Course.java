package org.example.student_manager.dao;

import lombok.Data;

@Data
public class Course {
    private String id;
    private String name;
    private String no;
    private String describe;
    private String time;
    private Integer num;
    private String teacher_id;
}
