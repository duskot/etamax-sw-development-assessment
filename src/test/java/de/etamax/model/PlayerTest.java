package de.etamax;

import de.etamax.model.Player;
import de.etamax.util.AnswerInputThread;
import org.junit.Ignore;
import org.junit.Test;

import java.io.StringReader;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testDefaultConstructor() {
        Player player = new Player();
        assertNull(player.getName());
        assertEquals(0, player.getScore());
        assertEquals(0, player.getTime());
    }

    @Test
    public void testParameterizedConstructor() {
        Player player = new Player(10, 30);
        assertNull(player.getName());
        assertEquals(10, player.getScore());
        assertEquals(30, player.getTime());
    }

    @Test
    public void testFullConstructor() {
        Player player = new Player("Alice", 20, 45);
        assertEquals("Alice", player.getName());
        assertEquals(20, player.getScore());
        assertEquals(45, player.getTime());
    }

    @Test
    public void testToString() {
        Player player = new Player("Carol", 15, 60);
        assertEquals("Carol, 15, 60", player.toString());
    }

    @Test
    public void testEnterNameWithInput() throws InterruptedException {
        AnswerInputThread answerInputThread = new AnswerInputThread(new Scanner(new StringReader("test")));
        answerInputThread.run();

        String enteredName = answerInputThread.getEnteredAnswer();

        assertEquals("test", enteredName);
        assertNotEquals("Test", enteredName);
    }

    @Test
    @Ignore
    public void testEnterNameWithTimeout() throws InterruptedException {
        String enteredName = Player.enterName();

        assertTrue(enteredName.startsWith("unknown_"));
    }
}