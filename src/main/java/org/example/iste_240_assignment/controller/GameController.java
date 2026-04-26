package org.example.iste_240_assignment.controller;

import org.example.iste_240_assignment.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public Optional<Game> getGameById(@PathVariable Integer id) {
        return gameService.getGameById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Game> getGameByName(@PathVariable String name) {
        return gameService.getGameByName(name);
    }

    @GetMapping("/subject/{subject}")
    public List<Game> getBySubject(@PathVariable String subject) {
        return gameService.getGameBySubject(subject);
    }

    @GetMapping("/difficulty/{difficulty}")
    public List<Game> getByDifficulty(@PathVariable int difficulty) {
        return gameService.getGameByDifficulty(difficulty);
    }

    @GetMapping("/available")
    public List<Game> getAvailableGames() {
        return gameService.getAvailableGames();
    }

    @GetMapping("/count/{available}")
    public long countAvailable(@PathVariable boolean available) {
        return gameService.getCountByAvailable(available);
    }

    @GetMapping("/search")
    public List<Game> searchGames(@RequestParam String name) {
        return gameService.getGameByName(name)
                .map(List::of)
                .orElse(List.of());
    }

    @PostMapping
    public Game addGame(@RequestBody Game game) {
        return gameService.saveGame(game);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Integer id, @RequestBody Game game) {
        game.setId(id);
        return gameService.updateGame(game);
    }

    @PutMapping("/availabilty/{id}")
    public int updateAvailability(@PathVariable Integer id,
                                  @RequestParam boolean status) {
        return gameService.updateGameAvailability(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        gameService.deleteGameById(id);
    }

    @DeleteMapping("/name/{name}")
    public long deleteByName(@PathVariable String name) {
        return gameService.deleteGameByName(name);
    }
}
