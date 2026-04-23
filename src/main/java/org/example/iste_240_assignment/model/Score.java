package org.example.iste_240_assignment.model;

import jakarta.persistence.*;

@Entity
@Table(name="scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scoreId;

    @ManyToOne
    @JoinColumn(name = "playerId", nullable = false)
    private player player;

    @ManyToOne
    @JoinColumn(name = "gameId", nullable = false)
    private Game game;

    private int currentLevel;
    private int roundsPlayed;
    private int attempts;
    private int points;
    private boolean gameOver;

    public Score() {}


    public int getScoreId() { return scoreId; }
    public void setScoreId(int scoreId) { this.scoreId = scoreId; }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }


}