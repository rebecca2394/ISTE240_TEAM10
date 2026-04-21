package org.example.iste_240_assignment.model;
import jakarta.persistence.*;

@Entity
@Table(name="games")
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="gameId", nullable=false)
    private int gameId;
    @Column(name="name", length=50, nullable=false)
    private String name;
    @Column(name="subject")
    private String subject;
    @Column(name="topic")
    private String topic;
    @Column(name="difficulty")
    private int difficulty;
    @Column(name="levels")
    private int levels;
    @Column(name="rounds")
    private int rounds;
    @Column(name="maxFails")
    private int maxFails;
    @Column(name="available")
    private boolean available;

    public Game(){
    }

    public Game(int gameId, String name, String subject, String topic,
                int difficulty, int levels, int rounds, int maxFails, boolean available) {
        this.gameId = gameId;
        this.name = name;
        this.subject = subject;
        this.topic = topic;
        this.difficulty = difficulty;
        this.levels = levels;
        this.rounds = rounds;
        this.maxFails = maxFails;
        this.available = available;
    }

    public int getId() {
        return gameId;
    }

    public void setId(int gameId) {
        this.gameId = gameId;
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
