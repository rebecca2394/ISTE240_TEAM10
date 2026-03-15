package org.example.iste_240_assignment.model;

public class Score {

    private Player player;
    private Game game;
    private int currentLevel;
    private int roundsPlayed;
    private int attempts;
    private int points;
    private boolean gameOver;

    public Score() {
    }

    public Score(Player player, Game game, int currentLevel,
                 int roundsPlayed, int attempts, int points, boolean gameOver) {
        this.player = player;
        this.game = game;
        this.currentLevel = currentLevel;
        this.roundsPlayed = roundsPlayed;
        this.attempts = attempts;
        this.points = points;
        this.gameOver = gameOver;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public String toString() {
        return "Score: Player-" + player.getUsername() +
                " , Game-" + game.getName() +
                " , Level-" + currentLevel +
                " , Points-" + points +
                " , Attempts-" + attempts;
    }
}