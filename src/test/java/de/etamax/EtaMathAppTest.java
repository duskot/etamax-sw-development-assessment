package de.etamax;

import org.junit.*;

import java.io.*;

/**
 *
 * @author Dusko Tesanovic
 */
public class EtaMathAppTest {

    /**
     * TODO
     * test game
     * test high score
     * test enter name time out
     *
     *
     */

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     *
     */
    @BeforeClass
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     *
     */
    @Test
    public void testMainInvalidInput() {
        // prepare input
        String input = "3\n0\n"; // User enters "3" then "0"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // run the main method
        EtaMathApp.main(new String[]{});

        // check that the output contains expected strings
        String output = outContent.toString();
        Assert.assertTrue(output.contains("Welcome to etaMath!"));
        Assert.assertTrue(output.contains("Incorrect input, please try again or enter 0 for exit!"));
        Assert.assertTrue(output.contains("Exiting..."));
    }
}
