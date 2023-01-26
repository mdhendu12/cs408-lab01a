package com.example.cs408lab1a__rock_paper_scissors;

import android.util.Log;

public class RockPaperScissors {

    private int pScore = 0, cScore = 0;
    private String scores, pWeapon, cWeapon, results;

    public void setScores () {
        this.scores = "Player: " + this.pScore + ", Computer: " + this.cScore;
    }

    public String getScoresAsString () {
        return this.scores;
    }


    public String getCWeaponAsString () {
        return this.cWeapon;
    }

    public String getPWeaponAsString () {
        return this.pWeapon;
    }

    public String getResultsAsString () {
        return this.results;
    }

    // 0 = rock, 1 = paper, 2 = scissors
    public void evaluateMatch (String pChoice) {
        String message = null;
        String comChoice = String.valueOf(Weapon.values()
                [(int) Math.floor(Math.random() *(Weapon.values().length))]).toUpperCase();
        this.pWeapon = "Player's Weapon: " + Weapon.valueOf(pChoice);
        this.cWeapon = "Computer's Weapon: " + Weapon.valueOf(comChoice);

        if (Weapon.valueOf(pChoice).ordinal() == Weapon.valueOf(comChoice).ordinal()) {
            message = "It's a draw! Please choose again.";
        }
        else {
            switch (Weapon.valueOf(pChoice)) {
                // player chooses rock scenarios
                case ROCK:
                    switch (Weapon.valueOf(comChoice)) {
                        case PAPER:
                            message = "Computer wins...Paper covers rock!";
                            ++cScore;
                            break;
                        case SCISSORS:
                            message = "Player wins... Rock blunts scissors!";
                            ++pScore;
                            break;
                        default:
                            break;
                    }
                    break;
                // player chooses paper scenarios
                case PAPER:
                    switch (Weapon.valueOf(comChoice)) {
                        case ROCK:
                            message = "Player wins... Paper covers rock!";
                            pScore++;
                            break;
                        case SCISSORS:
                            message = "Computer wins... Scissors cuts paper!";
                            ++cScore;
                            break;
                        default:
                            break;
                    }
                    break;
                // player chooses scissors scenarios
                case SCISSORS:
                    switch (Weapon.valueOf(comChoice)) {
                        case ROCK:
                            message = "Computer wins... Rock blunts scissors!";
                            ++cScore;
                            break;
                        case PAPER:
                            message = "Player wins... Scissors cuts paper!";
                            ++pScore;
                            break;
                        default:
                            break;
                    }
                    break;
            }

        }
        setScores();
        this.results = message;
    }

    public void reset() {
        this.results = this.scores = this.pWeapon = this.cWeapon = "";
        this.pScore = this.cScore = 0;
    }
}
