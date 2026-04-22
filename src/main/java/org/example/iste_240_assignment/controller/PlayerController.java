package org.example.iste_240_assignment.controller;

import org.example.iste_240_assignment.model.Player;
import org.example.iste_240_assignment.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<Player> getPlayerById(@PathVariable Integer id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/username/{username}")
    public Optional<Player> getPlayerByUsername(@PathVariable String username) {
        return playerService.getPlayerByUsername(username);
    }

    @GetMapping("/email/{email}")
    public Optional<Player> getPlayerByEmail(@PathVariable String email) {
        return playerService.getPlayerByEmail(email);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Integer id, @RequestBody Player player) {
        player.setId(id);
        return playerService.updatePlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        playerService.deletePlayerById(id);
    }

    @DeleteMapping("/username/{username}")
    public long deleteByUsername(@PathVariable String username) {
        return playerService.deletePlayerByUsername(username);
    }
}