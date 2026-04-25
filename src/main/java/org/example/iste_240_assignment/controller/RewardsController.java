package org.example.iste_240_assignment.controller;

import org.example.iste_240_assignment.model.Rewards;
import org.example.iste_240_assignment.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    @GetMapping
    public List<Rewards> getAllRewards() {
        return rewardsService.getAllRewards();
    }

    @GetMapping("/{id}")
    public Optional<Rewards> getRewardsById(@PathVariable Integer id) {
        return rewardsService.getRewardsById(id);
    }

    @GetMapping("/player/{playerId}")
    public Optional<Rewards> getByPlayerId(@PathVariable int playerId) {
        return rewardsService.getRewardsByPlayerId(playerId);
    }

    @GetMapping("/game/{gameId}")
    public List<Rewards> getByGameId(@PathVariable int gameId) {
        return rewardsService.getRewardsByGameId(gameId);
    }

    @GetMapping("/badges/{badges}")
    public List<Rewards> getByBadges(@PathVariable int badges) {
        return rewardsService.getRewardsByBadges(badges);
    }

    @GetMapping("/awarded")
    public List<Rewards> getAwardedBadges() {
        return rewardsService.getAwardedBadges();
    }

    @GetMapping("/count/{status}")
    public long countAwarded(@PathVariable boolean status) {
        return rewardsService.getCountByBadgeAwarded(status);
    }

    @GetMapping("/search")
    public List<Rewards> searchByPlayer(@RequestParam int playerId) {
        return rewardsService.getRewardsByPlayerId(playerId)
                .map(List::of)
                .orElse(List.of());
    }

    @PostMapping
    public Rewards addRewards(@RequestBody Rewards rewards) {
        return rewardsService.saveRewards(rewards);
    }

    @PutMapping("/{id}")
    public Rewards updateRewards(@PathVariable Integer id, @RequestBody Rewards rewards) {
        rewards.setId(id);
        return rewardsService.updateRewards(rewards);
    }

    @PutMapping("/bonus/{id}")
    public int updateBonus(@PathVariable Integer id,
                           @RequestParam int bonus) {
        return rewardsService.updateBonus(id, bonus);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        rewardsService.deleteRewardsById(id);
    }

    @DeleteMapping("/player/{playerId}")
    public long deleteByPlayerId(@PathVariable int playerId) {
        return rewardsService.deleteRewardsByPlayerId(playerId);
    }
}