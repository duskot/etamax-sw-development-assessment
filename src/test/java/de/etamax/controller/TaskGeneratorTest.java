package de.etamax.controller;

import de.etamax.model.Task;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskGeneratorTest {

    private TaskGenerator taskGenerator = new TaskGenerator();

    @Test
    public void testGenerateTask_addition() {
        Task task = taskGenerator.generateTask();
        //assertEquals("+", task.getOperator());
        assertTrue(task.getNum1() >= 0 && task.getNum1() < 100);
        assertTrue(task.getNum2() >= 0 && task.getNum2() < 100);
        assertTrue(task.getResult() >= 21 && task.getResult() < 100);
        assertEquals(task.getNum1() + task.getNum2(), task.getResult());
    }

    @Test
    public void testGenerateTask_subtraction() {
        Task task = taskGenerator.generateTask();
        //assertEquals("-", task.getOperator());
        assertTrue(task.getNum1() >= 21 && task.getNum1() < 100);
        assertTrue(task.getNum2() >= 0 && task.getNum2() <= task.getNum1() - 21);
        assertTrue(task.getResult() >= 21 && task.getResult() < 100);
        assertEquals(task.getNum1() - task.getNum2(), task.getResult());
    }

    @Test
    public void testGenerateTask_multiplication() {
        Task task = taskGenerator.generateTask();
        //assertEquals("*", task.getOperator());
        assertTrue(task.getNum1() >= 3 && task.getNum1() <= 12);
        assertTrue(task.getNum2() >= 3 && task.getNum2() <= 12);
        assertEquals(task.getNum1() * task.getNum2(), task.getResult());
    }

    @Test
    public void testGenerateTask_division() {
        Task task = taskGenerator.generateTask();
        //assertEquals("/", task.getOperator());
        assertTrue(task.getNum1() >= 9 && task.getNum1() <= 145);
        assertTrue(task.getNum2() >= 9 && task.getNum2() <= 145);
        assertTrue(task.getResult() >= 1 && task.getResult() <= 12);
        assertEquals(task.getNum1() / task.getNum2(), task.getResult());
    }

}


