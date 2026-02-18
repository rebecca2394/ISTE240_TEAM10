package org.example.iste_240_assignment;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Player {

    private int playerId;
    private String username;
    private String email;
    private String passwordHash;

    @PostConstruct
    public void init() {
        this.username = "player";
        this.email = "player@example.com";
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "Player : " + username;
    }
}
