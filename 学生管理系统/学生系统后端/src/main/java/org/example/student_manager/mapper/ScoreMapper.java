package org.example.student_manager.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.student_manager.dao.Score;

@Mapper
public interface ScoreMapper {

    @Insert("INSERT INTO score (course_id, student_id, score, stair) VALUES (#{courseId}, #{studentId}, #{score}, #{stair})")
    int add(Score score);
}
