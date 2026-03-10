package org.example.student_manager.controller;

import org.example.student_manager.dao.Score;
import org.example.student_manager.service.ScoreService;
import org.example.student_manager.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {
    private final ScoreService scoreService;
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @RequestMapping("/add")
    public Result<Integer> add(Score score) {
        return Result.ok(scoreService.add(score));
    }
}
