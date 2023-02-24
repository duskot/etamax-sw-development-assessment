package de.etamax.util;

import de.etamax.model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read from file and return list of read player objects,
 * and write to file player object.
 *
 * @author Dusko Tesanovic
 */
public class FileUtil {

    /**
     * This method takes array list as a parameter and write objects
     * type Player from the list in the txt file.
     *
     * @param highScoreList the array list to be written in the file
     * @param fileName      the file name parameter, usually be passed as null
     *                      except in tests so that the original result of the file
     *                      remains unchanged
     */
    public static void writeHighScoreListInFile(List<Player> highScoreList, String fileName) {
        // distinguish between regular and test use
        if (fileName == null) {
            fileName = "high_score.txt";
        }

        // write in file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Player player : highScoreList) {
                // write a line for each player
                writer.write(player.getName() + "," + player.getScore() + "," + player.getTime() + "\n");
            }
        } catch (IOException e) {
            // print the stack trace if IOException happened
            e.printStackTrace();
        }
    }

    /**
     * This method load lines from the txt file, parse them text into
     * certain vars, create objects type Player and create array list
     * of the objects. If the file doesn't exist it will be created.
     *
     * @param fileName the file name parameter, usually be passed as null
     *                 except in tests so that the original result of the file
     *                 remains unchanged
     * @return the array list of Player objects
     */

    public static List loadHighScoreDataFromFile(String fileName) {
        // create list object which will be returned
        List<Player> highScoreList = new ArrayList<>();

        // distinguish between regular and test use
        if (fileName == null) {
            fileName = "high_score.txt";
        }

        // check is file exist, if not, create a new file
        if (!new File(fileName).exists()) {
            try {
                // create file
                new File(fileName).createNewFile();
            } catch (IOException e) {
                // print the stack trace if IOException happened
                e.printStackTrace();
            }
        } else {
            // if exist reade from file
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                // read lines while EOF is not present
                while ((line = reader.readLine()) != null) {
                    // create string array for parsing line and set delimiter
                    String[] parts = line.split(",");
                    // parse values from line and create object through player constructor and add in list
                    highScoreList.add(new Player(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                }
            } catch (IOException e) {
                // print the stack trace if IOException happened
                e.printStackTrace();
            }
        }

        // return list
        return highScoreList;
    }
}
