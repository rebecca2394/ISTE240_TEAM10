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

        Game game1 = new Game(1,"Memory Card","Science","Solar System",1,5,3,3,true);
        Game game2 = new Game(2,"Tic Tac Toe","Math","Numbers",2,4,3,3,true);

        games.add(game1);
        games.add(game2);

        Player p1 = new Player(1,"player1","player1@email.com","1234");
        Player p2 = new Player(2,"player2","player2@email.com","1234");

        players.add(p1);
        players.add(p2);

        Score s1 = new Score(p1, game1, 1, 0, 0, 10, false);
        scores.add(s1);

        Rewards r1 = new Rewards(1,1,1,10,5);
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