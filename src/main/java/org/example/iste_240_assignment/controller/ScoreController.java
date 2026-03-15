package org.example.iste_240_assignment.controller;

import org.example.iste_240_assignment.model.*;
import org.example.iste_240_assignment.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ScoreController {

    private final GameService gameService;

    public ScoreController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/score")
    public String viewScores(Model model) {
        model.addAttribute("scores", gameService.getScores());
        return "Score";
    }

    @GetMapping("/score/add")
    public String addScoreForm(Model model) {

        model.addAttribute("players", gameService.getPlayers());
        model.addAttribute("games", gameService.getGames());

        return "add-score";
    }

    @PostMapping("/score/add")
    public String addScore(@RequestParam int playerId,
                           @RequestParam int gameId,
                           @RequestParam int currentLevel,
                           @RequestParam int roundsPlayed,
                           @RequestParam int attempts,
                           @RequestParam int points,
                           @RequestParam boolean gameOver) {

        Player player = gameService.getPlayers()
                .stream()
                .filter(p -> p.getPlayerId() == playerId)
                .findFirst()
                .orElse(null);

        Game game = gameService.getGames()
                .stream()
                .filter(g -> g.getId() == gameId)
                .findFirst()
                .orElse(null);

        Score score = new Score(player, game, currentLevel, roundsPlayed, attempts, points, gameOver);

        gameService.addScore(score);

        return "redirect:/add/success/score";
    }

    @GetMapping("/add/success/{entityName}")
    public String successPage(@PathVariable String entityName, Model model) {
        model.addAttribute("entityName", entityName);
        return "success";
    }
}