package de.etamax.util;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 *
 * @author Dusko Tesanovic
 */
public class AnswerInputThreadTest {

    /**
     *
     */
    @Test
    public void testGetEnteredAnswer() {
        // initialise input string
        String input = "test answer";
        // create the input stream object with the input string as the byte array input
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        // create scanner object
        Scanner scanner = new Scanner(inputStream);

        // initialise tread and start it
        AnswerInputThread inputThread = new AnswerInputThread(scanner);
        inputThread.start();

        // wait for the thread to complete
        try {
            inputThread.join();
        } catch (InterruptedException e) {
            // print the stack trace if thread is interrupted
            e.printStackTrace();
        }

        // get the entered answer
        String enteredAnswer = inputThread.getEnteredAnswer();
        // is the entered answer equal to the input string
        Assert.assertEquals(input, enteredAnswer);
    }

}
