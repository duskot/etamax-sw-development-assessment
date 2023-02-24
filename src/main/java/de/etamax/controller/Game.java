package de.etamax.util;

import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game {


    private static Timer timer = new Timer();
    public static Player runGame(int i, int score, int time, List uniqueTasksList) {

        long startTime = System.currentTimeMillis();
        long endTime;

       TimerTask timeIsUpTask = new TimerTask() {
           private boolean test;

           @Override
            public void run() {
                this.test = true;
                System.out.println("... sorry, you didn't respond fast enough");
            }
        };

        Task newTask;

        if (i < 20) {
            newTask = generateUniqueTask(uniqueTasksList);
            uniqueTasksList.add(newTask);
            System.out.println(newTask.getNum1() + " " + newTask.getOperationSymbol() +
                    " " + newTask.getNum2() + " = ");

//            Timer newTimer = new Timer();
//            newTimer.schedule(timeIsUpTask, 10000);

            Scanner scanner = new Scanner(System.in);
            String enteredValue = scanner.nextLine();

            // testiranje
/*            long startTimeForTask = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTimeForTask) < 10000) {
                enteredValue = scanner.nextLine();
                if(!enteredValue.isEmpty()) {
                    System.out.println("Break!!!!");
                    break;
                }
            }
            System.out.println("After while!");*/

            // probati sa boolean flag-om izlaz iz petlje/rekurzivni poziv

            // !!! ako je slovo idi na sledeci zadatak
            while (!isInteger(enteredValue)) {
                System.out.println("Please enter proper value again!");
                enteredValue = scanner.nextLine();
            }

            if (Integer.parseInt(enteredValue) == newTask.getResult()) {
                i++;
                score++;
//                newTimer.cancel();
//                timeIsUpTask.cancel();
                endTime = System.currentTimeMillis();
                time += getElapsedTime(startTime, endTime);
                return runGame(i, score, time, uniqueTasksList);
            } else {
                i++;
//                newTimer.cancel();
//                timeIsUpTask.cancel();
                endTime = System.currentTimeMillis();
                time += getElapsedTime(startTime, endTime);
                return runGame(i, score, time, uniqueTasksList);
            }
        }

        return new Player(score, time);
    }

    private static int getElapsedTime(long startTime, long endTime) {
        return Math.round((endTime - startTime) / 1000);
    }

    private static Task generateUniqueTask(List tasksList) {

        Task newTask = new TaskGenerator().generateTask();

        if (tasksList.contains(newTask)) {
            return generateUniqueTask(tasksList);
        }

        return newTask;
    }

    private static boolean isInteger(String s) {
        if (s == "") {
            return false;
        }

        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String enterName() {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        if (name == "") {
            System.out.println("Please enter your name!/n");
            return enterName();
        }
        return name;
    }

}