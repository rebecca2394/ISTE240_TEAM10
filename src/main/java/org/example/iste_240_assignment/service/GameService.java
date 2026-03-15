package org.example.iste_240_assignment.service;

import org.example.iste_240_assignment.model.Game;
import org.example.iste_240_assignment.model.Player;
import org.example.iste_240_assignment.model.Score;
import org.example.iste_240_assignment.model.Rewards;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private List<Game> games = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private List<Score> scores = new ArrayList<>();
    private List<Rewards> rewards = new ArrayList<>();

    public GameService() {

        Game game1 = new Game();
        game1.setId(1);
        game1.setName("Memory Card");
        game1.setSubject("Science");
        game1.setTopic("Solar System");
        game1.setDifficulty(1);
        game1.setLevels(5);
        game1.setRounds(3);
        game1.setMaxFails(3);
        game1.setAvailable(true);

        Game game2 = new Game();
        game2.setId(2);
        game2.setName("Tic Tac Toe");
        game2.setSubject("Math");
        game2.setTopic("Numbers");
        game2.setDifficulty(2);
        game2.setLevels(4);
        game2.setRounds(3);
        game2.setMaxFails(3);
        game2.setAvailable(true);
        games.add(game1);
        games.add(game2);

        Player p1 = new Player();
        p1.setPlayerId(1);
        p1.setUsername("player1");
        p1.setEmail("player1@email.com");
        p1.setPassword("1234");

        Player p2 = new Player();
        p2.setPlayerId(2);
        p2.setUsername("player2");
        p2.setEmail("player2@email.com");
        p2.setPassword("1234");
        players.add(p1);
        players.add(p2);

        Score s1 = new Score();
        s1.setPlayerId(1);
        s1.setGameId(1);
        s1.setCurrentLevel(1);
        s1.setRoundsPlayed(0);
        s1.setAttempts(0);
        s1.setPoints(10);
        s1.setGameOver(false);
        scores.add(s1);

        Rewards r1 = new Rewards();
        r1.setPlayerId(1);
        r1.setGameId(1);
        r1.setBadges(1);
        r1.setBonus(10);
        r1.setMaxDifficulty(5);
        rewards.add(r1);

    }
    public List<Game> getGames() {
        return games;
    }
    public void addGame(Game game) {
        games.add(game);
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void addPlayer(Player player) {
        players.add(player);
    }
    public List<Score> getScores() {
        return scores;
    }
    public void addScore(Score score) {
        scores.add(score);
    }
    public List<Rewards> getRewards() {
        return rewards;
    }
    public void addRewards(Rewards reward) {
        rewards.add(reward);
    }

}