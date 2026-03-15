package org.example.iste_240_assignment.model;

public class Player {

    private int playerId;
    private String username;
    private String email;
    private String password;

    public Player(int playerId, String username, String email, String password) {
        this.playerId = playerId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Player() {}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player : " + username;
    }
}
