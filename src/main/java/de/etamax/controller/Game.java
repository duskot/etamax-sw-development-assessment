package de.etamax.controller;

import de.etamax.model.Player;
import de.etamax.model.Task;
import de.etamax.util.AnswerInputThread;

import java.util.List;
import java.util.Scanner;
import java.util.Timer;

/**
 * This class implements the logic of a simple math game,
 * where the player has to solve basic arithmetic operations
 * in a limited amount of time. The class provides a runGame
 * method, which takes as input the initial values for score,
 * time, and a list of unique tasks, and returns a Player object,
 * representing the final state of the game.
 *
 * @author Dusko Tesanovic
 */
public class Game {

    // declare and initialise class object and variables
    private static Scanner scanner;
    private static Timer timer = new Timer();
    private static boolean isNextTask = false;

    /**
     * Runs the math game with a limited amount of time and a list of
     * unique tasks. The method takes as input the current state of
     * the game: the current task index, the score, the elapsed time,
     * and the list of past tasks. It generates a new task, prompts
     * the user to input an answer, and verifies if the answer is correct.
     * If the answer is correct, the score is incremented, and the elapsed
     * time is updated with the time taken to solve the task. If the answer
     * is wrong or the time is up, the elapsed time is updated, and the next
     * task is generated. The game stops after 20 tasks, and the final score
     * and time are returned in a Player object.
     *
     * @param indexOfCurrentTask the index of the current task
     * @param currentScore the current score
     * @param elapsedTime the elapsed time
     * @param uniquePastTasksList the list of past tasks
     * @return the final state of the game as a Player object
     */
    public static Player runGame(int indexOfCurrentTask, int currentScore, int elapsedTime, List uniquePastTasksList) {
        // declare task object
        Task newTask;

        // declare variables for time measuring
        long startTime = System.currentTimeMillis();
        long endTime;

        // check number of displayed tasks, 20 tasks in total
        if (indexOfCurrentTask < 20) {
            // generate new task and add it to unique list
            newTask = generateUniqueTask(uniquePastTasksList);
            uniquePastTasksList.add(newTask);

            // display task in console
            System.out.println(newTask.getNum1() + " " + newTask.getOperationSymbol() +
                    " " + newTask.getNum2() + " = ?");

            // instantiate scanner object
            scanner = new Scanner(System.in);

            // create and start a new thread to listen for user input while a timer runs in the background
            AnswerInputThread answerInputThread = new AnswerInputThread(scanner);
            answerInputThread.start();
            try {
                // wait for user input for up to 10 seconds
                answerInputThread.join(10000);
            } catch (InterruptedException e) {
                // print the stack trace if thread interrupted
                e.printStackTrace();
            }

            // get entered answer from thread
            String enteredValue = answerInputThread.getEnteredAnswer();

            // check is input thread interrupted, user did not enter answer within 10 seconds
            if (enteredValue == null) {
                // display message, increase index by 1, and add 10 seconds to elapsed time
                System.out.println("... sorry, you didn't respond fast enough");
                indexOfCurrentTask++;
                elapsedTime += 10;
                // recursive call for next task
                return runGame(indexOfCurrentTask, currentScore, elapsedTime, uniquePastTasksList);
            }

            // check is entered answer correct
            if (isInteger(enteredValue) && Integer.parseInt(enteredValue) == newTask.getResult()) {
                // if true - increase index and score by 1, and add elapsed time
                endTime = System.currentTimeMillis();
                indexOfCurrentTask++;
                currentScore++;
                elapsedTime += getElapsedTime(startTime, endTime);
                // recursive call for next task
                return runGame(indexOfCurrentTask, currentScore, elapsedTime, uniquePastTasksList);
            } else {
                // if false - increase index by 1, and add elapsed time
                endTime = System.currentTimeMillis();
                indexOfCurrentTask++;
                elapsedTime += getElapsedTime(startTime, endTime);
                // recursive call for next task
                return runGame(indexOfCurrentTask, currentScore, elapsedTime, uniquePastTasksList);
            }
        }

        // return player object with final score and time after last task
        return new Player(currentScore, elapsedTime);
    }

    /**
     * Takes a start time and end time in milliseconds and calculates
     * the elapsed time in seconds.
     *
     * @param startTime the start time in milliseconds
     * @param endTime the end time in milliseconds
     * @return the elapsed time in seconds
     */
    private static int getElapsedTime(long startTime, long endTime) {
        // calculate and return elapsed time in seconds
        return Math.round((endTime - startTime) / 1000);
    }

    /**
     * Generates a unique task that is not already in the list of tasks.
     *
     * @param tasksList the list of tasks to check for uniqueness
     * @return the Task object that is not already in the list
     */
    protected static Task generateUniqueTask(List tasksList) {
        // generate a new task using the TaskGenerator class
        Task newTask = new TaskGenerator().generateTask();

        // check if generated task exist, if exist recursively generate a new task
        if (tasksList.contains(newTask)) {
            return generateUniqueTask(tasksList);
        }

        // return unique task
        return newTask;
    }

    /**
     * Takes the string from scanner input and check is integer or not
     * using parseInt methode from Integer class. If value in string
     * is not integer catch NumberFormatException and return false.
     *
     * @param s the string from scanner input to be tested is integer or not
     * @return the boolean value
     */
    private static boolean isInteger(String s) {
        // check is passed string empty
        if (s.isEmpty()) {
            return false;
        }
        try {
            // parse string to int if possible and return it
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            // return false if NumberFormatException happened
            return false;
        }
    }
}