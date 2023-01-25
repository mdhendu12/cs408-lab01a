package com.example.cs408lab1a__rock_paper_scissors;

public enum Weapon {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");
    private String message;

    private Weapon(String msg) { message = msg; }

    @Override
    public String toString() { return message; }
}
