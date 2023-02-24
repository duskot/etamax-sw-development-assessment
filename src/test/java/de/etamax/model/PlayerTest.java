package de.etamax.model;

import de.etamax.util.AnswerInputThread;
import org.junit.Ignore;
import org.junit.Test;

import java.io.StringReader;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 *
 * @author Dusko Tesanovic
 */
public class PlayerTest {

    /**
     *
     */
    @Test
    public void testDefaultConstructor() {
        Player player = new Player();

        assertNull(player.getName());
        assertEquals(0, player.getScore());
        assertEquals(0, player.getTime());
    }

    /**
     *
     */
    @Test
    public void testParameterizedConstructor() {
        Player player = new Player(18, 98);

        assertNull(player.getName());
        assertEquals(18, player.getScore());
        assertEquals(98, player.getTime());
    }

    /**
     *
     */
    @Test
    public void testFullConstructor() {
        Player player = new Player("TestName", 20, 111);

        assertEquals("TestName", player.getName());
        assertEquals(20, player.getScore());
        assertEquals(111, player.getTime());
    }

    /**
     *
     */
    @Test
    public void testGettersAndSetters() {
        Player player = new Player();
        player.setName("TestName");
        player.setScore(13);
        player.setTime(97);

        assertEquals("TestName", player.getName());
        assertEquals(13, player.getScore());
        assertEquals(97, player.getTime());
    }

    /**
     *
     */
    @Test
    public void testToString() {
        Player player = new Player("TestName", 15, 60);

        assertEquals("TestName, 15, 60", player.toString());
    }

    /**
     *
     * @throws InterruptedException
     */
    @Test
    public void testEnterNameWithInput() throws InterruptedException {
        AnswerInputThread answerInputThread = new AnswerInputThread(new Scanner(new StringReader("TestName")));
        answerInputThread.run();
        String enteredName = answerInputThread.getEnteredAnswer();

        assertEquals("TestName", enteredName);
        assertNotEquals("testName", enteredName);
    }

    /**
     *
     * @throws InterruptedException
     */
    @Test
    @Ignore
    public void testEnterNameWithTimeout() throws InterruptedException {
        String enteredName = Player.enterName();

        assertTrue(enteredName.startsWith("unknown_"));
    }
}