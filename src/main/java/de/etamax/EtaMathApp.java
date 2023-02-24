package de.etamax;

import de.etamax.util.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class App {

    /*
     * TODO
     *
     * implement time limitation for each task
     *
     * tests
     * exceptions
     * */
    static List<Task> uniqueTasksList;

    static Game game;
    static FileUtil fileUtil;

    public static void main(String[] args) throws IOException {

        boolean running = true;

        List<Player> highScoreList = fileUtil.loadHighScoreDataFromFile();

        Player currentPlayer;

        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("Welcome to etaMath!");
            System.out.println("Type 1 to start game,");
            System.out.println("Type 2 to show highs-cores");

            String typedValue = scanner.nextLine();

            switch (typedValue) {
                // start game
                case "1":
                    uniqueTasksList = new ArrayList<>();

                    currentPlayer = game.runGame(0, 0, 0, uniqueTasksList);

                    highScoreList.add(currentPlayer);

                    Collections.sort(highScoreList, new ScoreComparator());

                    // displaying massages after a player has done
                    System.out.println("Great! Within " + currentPlayer.getTime() +
                            " seconds, you solved " + currentPlayer.getScore() + " correctly!");
                    System.out.println("You made it to the highest! (Place " + (highScoreList.indexOf(currentPlayer) + 1) + ") What is your name?");

                    // entering name after a player has done
                    currentPlayer.setName(game.enterName());

                    // updating score file
                    fileUtil.writeHighScoreListInFile(highScoreList);

                    break;
                // display high scores list
                case "2":
                    System.out.println("High scores list:");
                    System.out.println("Position, Name, Score, Time");
                    highScoreList.forEach((p) -> System.out.println((highScoreList.indexOf(p) + 1) + ". " + p));
                    break;
                default:
                    System.out.println("Incorrect input, please try again or enter 0 for exit!");
                    if (scanner.nextLine().equals("0")) {
                        scanner.close();
                        System.out.println("Exiting...");
                        running = false;
                    }
                    break;
            }
        }
    }
}

