package org.example.iste_240_assignment.controller;

import org.example.iste_240_assignment.model.Rewards;
import org.example.iste_240_assignment.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RewardsController {

    private final GameService gameService;

    public RewardsController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/rewards")
    public String viewRewards(Model model) {
        model.addAttribute("rewards", gameService.getRewards());
        return "Rewards";
    }

    @GetMapping("/rewards/add")
    public String addRewardsForm() {
        return "add-Rewards";
    }

    @PostMapping("/rewards/add")
    public String addRewards(@RequestParam int playerId,
                             @RequestParam int gameId,
                             @RequestParam int badges,
                             @RequestParam int bonus,
                             @RequestParam int maxDifficulty) {

        gameService.addRewards(new Rewards(playerId, gameId, badges, bonus, maxDifficulty));

        return "redirect:/add/success/rewards";
    }

    @GetMapping("/add/success/{entityName}")
    public String successPage(@PathVariable String entityName, Model model) {
        model.addAttribute("entityName", entityName);
        return "Success";
    }
}
