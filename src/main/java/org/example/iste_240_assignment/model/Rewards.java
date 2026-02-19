package org.example.iste_240_assignment.model;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Rewards {

    private int gameId;
    private int playerId;
    private int badges;
    private int bonus;
    private int maxDifficulty;
    private boolean badgeAwarded;

    @PostConstruct
    public void init() {
        this.badges = 0;
        this.bonus = 0;
        this.maxDifficulty = 5;
        this.badgeAwarded = false;
    }

    public int getGameId() {
        return gameId;
    }
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    public int getBadges() {
        return badges;
    }
    public void setBadges(int badges) {
        this.badges = badges;
    }
    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    public int getMaxDifficulty() {
        return maxDifficulty;
    }
    public void setMaxDifficulty(int maxDifficulty) {
        this.maxDifficulty = maxDifficulty;
    }

    public void addBonus(boolean correct, int attempts) {
        if (correct && attempts == 0) {
            this.bonus+=10;
        }
    }
    public void addBadges(Game game, boolean correct) {
        if (!badgeAwarded && game.getDifficulty() == maxDifficulty && correct) {
            this.badges++;
            this.badgeAwarded = true;
        }
    }

    @Override
    public String toString() {
        return "Rewards: Badges=" + badges +
                ", Bonus=" + bonus;
    }
}
