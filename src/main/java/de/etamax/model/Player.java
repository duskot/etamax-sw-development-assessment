package de.etamax.model;

import de.etamax.util.AnswerInputThread;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * This class represents a player in a game, with a name,
 * score, and time taken to complete the game.
 *
 * @author Dusko Tesanovic
 */
public class Player {

    // declare class variables
    String name;
    int score;
    int time;

    // constructors default and parametrised
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

    /**
     * This method allows player to enter the name after the game
     * is done, if the player doesn't enter the name within 30 seconds
     * the name will be generated and added automatically.
     *
     * @return the player's name
     * @
     */
    public static String enterName() {
        // create a new scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // declaration and initialisation variables
        String enteredName;
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        // create and start a new thread to listen for user input while a timer runs in the background
        AnswerInputThread answerInputThread = new AnswerInputThread(scanner);
        answerInputThread.start();
        try {
            // wait for user input for up to 60 seconds
            answerInputThread.join(60000);
        } catch (InterruptedException e) {
            // print the stack trace if thread interrupted
            e.printStackTrace();
        }

        // if the user did not enter a name within the given time limit, generate a name automatically
        if (answerInputThread.getEnteredAnswer() == null || answerInputThread.getEnteredAnswer().isEmpty()) {
            enteredName = "unknown_" + new SimpleDateFormat("yyMMdd_HHmm").format(new java.util.Date());
            System.out.println("The time for entering the name is up or you enter nothing!\nYour name will be generated automatically!\nThe name is: " + enteredName);
        } else {
            // if the user entered a name, store it in the enteredName variable
            enteredName = answerInputThread.getEnteredAnswer();
        }

        // return the name
        return enteredName;
    }

    // getters and setters
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

    /**
     * Returns a string representation of the Player object,
     * in the format "name, score, time".
     *
     * @return the string representation of the Player object
     */
    @Override
    public String toString() {
        return name + ", " + score + ", " + time;
    }
}
