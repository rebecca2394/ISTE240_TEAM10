package org.example.iste_240_assignment.model;

import jakarta.persistence.*;

@Entity
@Table(name="rewards")
public class Rewards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="rewardId", nullable=false)
    private int rewardId;

    @Column(name="gameId")
    private int gameId;

    @Column(name="playerId")
    private int playerId;

    @Column(name="badges")
    private int badges;

    @Column(name="bonus")
    private int bonus;

    @Column(name="maxDifficulty")
    private int maxDifficulty;

    @Column(name="badgeAwarded")
    private boolean badgeAwarded;

    public Rewards() {
    }

    public Rewards(int rewardId, int playerId, int gameId, int badges, int bonus, int maxDifficulty, boolean badgeAwarded) {
        this.rewardId = rewardId;
        this.playerId = playerId;
        this.gameId = gameId;
        this.badges = badges;
        this.bonus = bonus;
        this.maxDifficulty = maxDifficulty;
        this.badgeAwarded = badgeAwarded;
    }

    public int getId() {
        return rewardId;
    }

    public void setId(int rewardId) {
        this.rewardId = rewardId;
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

    public boolean isBadgeAwarded() {
        return badgeAwarded;
    }

    public void setBadgeAwarded(boolean badgeAwarded) {
        this.badgeAwarded = badgeAwarded;
    }

    public void addBonus(boolean correct, int attempts) {
        if (correct && attempts == 0) {
            this.bonus += 10;
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
                ", Bonus=" + bonus +
                ", MaxDifficulty=" + maxDifficulty;
    }
}