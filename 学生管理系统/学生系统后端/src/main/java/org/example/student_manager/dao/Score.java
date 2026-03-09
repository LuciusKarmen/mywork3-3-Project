package org.example.student_manager.dao;

import lombok.Data;

@Data
public class Score {
    private String id;
    private String courseId;
    private String studentId;
    private Double score;
    private String stair;
}
