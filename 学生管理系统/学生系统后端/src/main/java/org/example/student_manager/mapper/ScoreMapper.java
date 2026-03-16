package org.example.student_manager.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.student_manager.dao.Score;

@Mapper
public interface ScoreMapper {

    @Insert("INSERT INTO score (course_id, student_id, score, stair) VALUES (#{courseId}, #{studentId}, #{score}, #{stair})")
    int add(Score score);

    //删除成绩
     @Insert("DELETE FROM score WHERE studentId = #{studentId}")
      int deleteByStudentId(String studentId);


    @Delete("DELETE FROM score WHERE courseId = #{courseId}")
    int deleteByCourseId(String courseId);

}
