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

    @GetMapping // Get all records [cite: 135]
    public List<Score> getAll() {
        return scoreService.getAllScores();
    }

    @GetMapping("/{id}") // Get one by ID [cite: 135]
    public Score getOne(@PathVariable int id) {
        return scoreService.getScoreById(id).orElse(null);
    }

    @PostMapping // Create new record [cite: 135]
    public Score create(@RequestBody Score score) {
        return scoreService.saveScore(score);
    }

    @PutMapping("/{id}") // Update points [cite: 135]
    public int updatePoints(@PathVariable int id, @RequestParam int points) {
        return scoreService.updateScorePoints(id, points);
    }

    @DeleteMapping("/{id}") // Delete [cite: 135]
    public void delete(@PathVariable int id) {
        scoreService.deleteScore(id);
    }
}