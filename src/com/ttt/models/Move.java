package com.ttt.models;

public class Move {

    private int index = -1;

    private int score;

    public Move() {
    }

    public Move(int score) {
        this.score = score;
    }

    public int getIndex() {

        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Move{" +
                "index=" + index +
                ", score=" + score +
                '}';
    }
}
