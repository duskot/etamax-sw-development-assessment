package de.etamax.util;

import static org.junit.Assert.*;

import de.etamax.model.Player;
import org.junit.Test;

/**
 *
 * @author Dusko Tesanovic
 */
public class ScoreComparatorTest {

    /**
     *
     */
    @Test
    public void testCompare() {
        Player player1 = new Player("Player 1", 10, 100);
        Player player2 = new Player("Player 2", 20, 50);

        ScoreComparator comparator = new ScoreComparator();

        int result;

        result = comparator.compare(player1, player2);
        // Player1 should come before Player2
        assertFalse(result < 0);
        result = comparator.compare(player2, player1);
        // Player2 should come before Player1
        assertTrue(result < 0);

        // test for equal scores but different times
        Player player3 = new Player("Player 3", 20, 110);
        Player player4 = new Player("Player 4", 20, 100);

        result = comparator.compare(player3, player4);
        // Player 4 should come before player 3
        assertTrue(result > 0);

        // test for equal scores and times
        Player player5 = new Player("Player 5", 15, 99);
        Player player6 = new Player("Player 6", 15, 99);

        result = comparator.compare(player5, player6);
        // Player 5 and Player 6 should be equal
        assertTrue(result == 0);
    }
}
