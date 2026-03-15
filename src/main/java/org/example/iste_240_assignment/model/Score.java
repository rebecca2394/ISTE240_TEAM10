package org.example.iste_240_assignment.model;

public class Score {

    private int playerId;
    private int gameId;
    private int currentLevel;
    private int roundsPlayed;
    private int attempts;
    private int points;
    private boolean gameOver;

    public Score() {
    }

    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    public int getGameId() {
        return gameId;
    }
    public void setGameId(int gameId) {
        this.gameId = gameId;
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

    public void progress(boolean correct, Game game) {

        if (gameOver) {
            return;
        }
        if (!game.isAvailable()) {
            return;
        }
        if (correct) {
            this.points += 10;
            this.attempts = 0;
            this.roundsPlayed++;
        } else {
            this.attempts++;
        }
        if (roundsPlayed >= game.getRounds()) {
            this.currentLevel++;
            this.roundsPlayed=0;
        }
        if (attempts >= game.getMaxFails()) {
            this.points = 0;
            this.gameOver = true;
        }
    }

    @Override
    public String toString() {
        return "Score: Player-" + playerId +
                " , Game-" + gameId +
                " , Level-" + currentLevel +
                " , Points-" + points +
                " , Attempts-" + attempts;
    }
}