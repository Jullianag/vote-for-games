package br;

import java.io.Serializable;

public class Game implements Serializable {

    private String name;
    private int number;
    private int votes;

    public Game(String name, int number) {
        this.name = name;
        this.number = number;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
