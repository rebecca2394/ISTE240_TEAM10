package org.example.iste_240_assignment.model;

import jakarta.persistence.*;

@Entity
@Table(name="scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="scoreId", nullable = false)
    private int scoreId;

    @ManyToOne
    @JoinColumn(name = "playerId", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "gameId", nullable = false)
    private Game game;

    @Column(name="currentLevel")
    private int currentLevel;
    @Column(name="roundsPlayed")
    private int roundsPlayed;
    @Column(name="attempts")
    private int attempts;
    @Column(name="points")
    private int points;
    @Column(name="gameOver")
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