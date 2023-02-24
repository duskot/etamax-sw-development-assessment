package de.etamax.util;

import de.etamax.model.Player;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 *
 * @author Dusko Tesanovic
 */
public class FileUtilTest {

    /**
     *
     * @throws IOException
     */
    @Test
    public void testWriteHighScoreListInFile() throws IOException {
        // create a list of players with dummy player data
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", 15, 80));
        players.add(new Player("Player 2", 20, 90));

        // write the list to the file
        FileUtil.writeHighScoreListInFile(players, "high_score_test.txt");

        // load the list from the file and check that it matches the original list
        List<Player> loadedPlayers = FileUtil.loadHighScoreDataFromFile("high_score_test.txt");
        assertEquals(players.size(), loadedPlayers.size());
        // loop through the list and match data loaded from the file
        players.forEach((p)->assertEquals(p.getName(), loadedPlayers.get(players.indexOf(p)).getName()));
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testLoadHighScoreDataFromFile() throws IOException {
        // create a file with dummy player data
        FileUtil.writeHighScoreListInFile(List.of(
                new Player("Player 1", 13, 120),
                new Player("Player 2", 18, 150)
        ), "high_score_test.txt");

        // load the player data from the file and check that it matches the expected list of players
        List<Player> players = FileUtil.loadHighScoreDataFromFile("high_score_test.txt");
        assertEquals(2, players.size());
        assertEquals("Player 1", players.get(0).getName());
        assertEquals(13, players.get(0).getScore());
        assertEquals(120, players.get(0).getTime());
        assertEquals("Player 2", players.get(1).getName());
        assertEquals(18, players.get(1).getScore());
        assertEquals(150, players.get(1).getTime());
    }
}

