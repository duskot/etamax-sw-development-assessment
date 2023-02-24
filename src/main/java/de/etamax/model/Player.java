package de.etamax.util;

public class Player {

    String name;
    int score;
    int time;

    public Player() {
    }

    public Player(int score, int time) {
        this.score = score;
        this.time = time;
    }

    public Player(String name, int score, int time) {
        this.name = name;
        this.score = score;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return name + ", " + score + ", " + time;
    }
}
