package org.example.iste_240_assignment.controller;

import org.example.iste_240_assignment.model.Game;
import org.example.iste_240_assignment.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game")
    public String viewGames(Model model) {
        model.addAttribute("games", gameService.getGames());
        return "game";
    }

    @GetMapping("/game/add")
    public String addGameForm() {
        return "add-game";
    }

    @PostMapping("/game/add")
    public String addGame(@RequestParam int gameId,
                          @RequestParam String name,
                          @RequestParam String subject,
                          @RequestParam String topic,
                          @RequestParam int difficulty,
                          @RequestParam int levels,
                          @RequestParam int rounds,
                          @RequestParam int maxFails,
                          @RequestParam boolean available) {

        gameService.addGame(new Game(gameId, name, subject, topic, difficulty, levels, rounds, maxFails, available));

        return "redirect:/add/success/game";
    }

    @GetMapping("/add/success/{entityName}")
    public String successPage(@PathVariable String entityName, Model model) {
        model.addAttribute("entityName", entityName);
        return "success";
    }
}