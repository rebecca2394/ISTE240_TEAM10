package org.example.iste_240_assignment.model;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Game {

    private int id;
    private String name;
    private String subject;
    private String topic;
    private int difficulty;
    private int levels;
    private int rounds;
    private int maxFails;
    private boolean available;

    @PostConstruct
    public void init() {
        this.name = "Memory Card";
        this.subject = "Science";
        this.topic = "Solar System";
        this.difficulty = 1;
        this.levels = 5;
        this.rounds = 3;
        this.maxFails = 3;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getMaxFails() {
        return maxFails;
    }

    public void setMaxFails(int maxFails) {
        this.maxFails = maxFails;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getTotalRounds() {
        return levels * rounds;
    }

    @Override
    public String toString() {
        return "Game: " + name +
                " , Subject: " + subject +
                " , Topic: " + topic +
                " , Difficulty: " + difficulty;
    }

}
