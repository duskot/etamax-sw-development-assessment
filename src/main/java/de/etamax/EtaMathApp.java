package de.etamax;

import de.etamax.controller.Game;
import de.etamax.model.Player;
import de.etamax.model.Task;
import de.etamax.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for the EtaMath application
 *
 * @author Dusko Tesanovic
 */
public class EtaMathApp {

    // declare list of unique tasks played
    static List<Task> uniqueTasksList;

    /**
     *  Main method for the application.
     *
     *  @param args Command line arguments, currently not used.
     */
    public static void main(String[] args) {

        // is application running flag
        boolean running = true;

        // load high scores data from file
        List<Player> highScoreList = FileUtil.loadHighScoreDataFromFile(null);

        // declare player
        Player currentPlayer;

        // instantiate scanner object
        Scanner scanner = new Scanner(System.in);

        // main loop for the application
        while (running) {
            // welcome message
            System.out.println("Welcome to etaMath!");
            System.out.println("Type 1 to start game,");
            System.out.println("Type 2 to show highs-cores");

            // take user entry
            String typedValue = scanner.nextLine();

            switch (typedValue) {
                // start game
                case "1":
                    // instantiate list
                    uniqueTasksList = new ArrayList<>();

                    // run the game and get the result
                    currentPlayer = Game.runGame(0, 0, 0, uniqueTasksList);

                    // add the player to the list
                    highScoreList.add(currentPlayer);

                    // sort the list by custom comparator
                    highScoreList.sort(new ScoreComparator());

                    // display messages after the player finished game
                    System.out.println("Great! Within " + currentPlayer.getTime() +
                            " seconds, you solved " + currentPlayer.getScore() + " correctly!");
                    System.out.println("You made it to the highest! (Place " + (highScoreList.indexOf(currentPlayer) + 1) + ") What is your name? (60 seconds for entering)");

                    // enter name after the player finished game
                    currentPlayer.setName(Player.enterName());

                    // update high score file
                    FileUtil.writeHighScoreListInFile(highScoreList, null);

                    break;
                // display high scores list
                case "2":
                    System.out.println("High scores list:");
                    System.out.println("Position, Name, Score, Time");
                    // loop through the list and display it
                    highScoreList.forEach((p) -> System.out.println((highScoreList.indexOf(p) + 1) + ". " + p));
                    break;
                default:
                    // exit or continue
                    System.out.println("Incorrect input, please try again or enter 0 for exit!");
                    // test entry for exit
                    if (scanner.nextLine().equals("0")) {
                        scanner.close();
                        System.out.println("Exiting...");
                        running = false;
                    }
                    break;
            }
        }
        System.out.println("Good bye and have a nice day! :-)");
    }
}

