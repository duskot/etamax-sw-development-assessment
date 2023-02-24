package de.etamax.controller;

import de.etamax.model.Player;
import de.etamax.model.Task;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author Dusko Tesanovic
 */
public class GameTest {

    private Game game;

    /**
     *
     */
    @Before
    public void setUp() {
        game = new Game();
    }

    /**
     *
     */
    @Test
    public void testGenerateUniqueTask() {
        // Create a list of tasks with one task
        List<Task> tasksList = new ArrayList<>();
        tasksList.add(new Task(21, 0, "+", 21));

        // Generate a new task and check that it is not in the list
        Task newTask = game.generateUniqueTask(tasksList);
        Assert.assertFalse(tasksList.contains(newTask));

        // Add the new task to the list and generate another task
        tasksList.add(newTask);
        newTask = game.generateUniqueTask(tasksList);

        // Check that the new task is not in the list and the list has 2 tasks
        Assert.assertFalse(tasksList.contains(newTask));
        Assert.assertEquals(2, tasksList.size());
    }

    /**
     *
     */
    @Test
    @Ignore
    public void testRunGameReturnsCorrectResultForValidAnswer() {
        List<Task> uniqueTasksList = new ArrayList<>();
        Task task = new Task(20, 30, "+", 50);
        uniqueTasksList.add(task);
        Player player = Game.runGame(0, 0, 0, uniqueTasksList);
        assertEquals(1, player.getScore());
    }

    /**
     *
     */
    @Test
    @Ignore
    public void testRunGameReturnsCorrectResultForNullAnswer() {
        List<Task> uniqueTasksList = new ArrayList<>();
        Task task = new Task(20, 30, "+", 50);
        uniqueTasksList.add(task);
        Player player = Game.runGame(0, 0, 0, uniqueTasksList);
        assertEquals(0, player.getScore());
    }

}
