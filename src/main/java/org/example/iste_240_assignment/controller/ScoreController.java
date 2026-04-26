package org.example.iste_240_assignment.controller;

import org.example.iste_240_assignment.model.Score;
import org.example.iste_240_assignment.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<Score> getAll() {
        return scoreService.getAllScores();
    }

    @GetMapping("/{id}")
    public Score getOne(@PathVariable int id) {
        return scoreService.getScoreById(id).orElse(null);
    }

    @GetMapping("/player/{playerId}")
    public List<Score> getScoresByPlayer(@PathVariable int playerId) {
        return scoreService.getScoresByPlayer(playerId);
    }

    @PostMapping
    public Score create(@RequestBody Score score) {
        return scoreService.saveScore(score);
    }

    @PutMapping("/{id}")
    public int updatePoints(@PathVariable int id, @RequestParam int points) {
        return scoreService.updateScorePoints(id, points);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        scoreService.deleteScore(id);
    }
}