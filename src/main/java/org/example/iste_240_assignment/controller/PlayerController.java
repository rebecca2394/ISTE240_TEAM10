package org.example.iste_240_assignment.controller;

import org.example.iste_240_assignment.model.Player;
import org.example.iste_240_assignment.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    private final GameService gameService;

    public PlayerController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/player")
    public String viewPlayers(Model model) {
        model.addAttribute("players", gameService.getPlayers());
        return "player";
    }

    @GetMapping("/player/add")
    public String addPlayerFoam() {
        return "add-player";
    }

    @PostMapping("/player/add")
    public String addPlayer(@RequestParam int playerId,
                            @RequestParam String username,
                            @RequestParam String email,
                            @RequestParam String password,
                            Model model) {
        gameService.addPlayer(new Player(playerId, username, email, password));
        model.addAttribute("entityName", "player");
        return "success";
    }

    @GetMapping("add/success/{entityName}")
    public String successPage(@PathVariable String entityName, Model model) {
        model.addAttribute("entityName", entityName);
        return "success";
    }
}
