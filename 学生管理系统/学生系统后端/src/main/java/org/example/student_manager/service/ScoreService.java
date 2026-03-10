package org.example.student_manager.service;

import org.example.student_manager.dao.Score;
import org.example.student_manager.mapper.ScoreMapper;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    private  final ScoreMapper scoreMapper;
    public ScoreService(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }
    public int add(Score  score) {
        score.setId(java.util.UUID.randomUUID().toString());
        return scoreMapper.add(score);
    }
}
