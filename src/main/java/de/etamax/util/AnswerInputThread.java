package de.etamax.util;

import java.util.Scanner;

/**
 * Class to manage creation of new thread, use scanner
 * for user input and return entered value, which extends
 * thread class.
 *
 * @author Dusko Tesanovic
 */
public class AnswerInputThread extends Thread {

    // declare class objects and variables
    private Scanner scanner;
    private String enteredAnswer;

    // constructor
    public AnswerInputThread(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * This method takes user entry from keypad.
     */
    public void run() {
        this.enteredAnswer = this.scanner.nextLine();
    }

    /**
     * This method returns entered value
     *
     * @return the string object
     */
    public String getEnteredAnswer() {
        return this.enteredAnswer;
    }
}
