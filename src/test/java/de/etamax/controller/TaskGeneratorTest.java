package de.etamax.controller;

import de.etamax.model.Task;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Dusko Tesanovic
 */
public class TaskGeneratorTest {

    private final TaskGenerator taskGenerator = new TaskGenerator();

    /**
     *
     */
    @Test
    public void testGenerateTaskAllOperations() {

        boolean isAddTested = false;
        boolean isSubTested = false;
        boolean isMulTested = false;
        boolean isDivTested = false;

        while (!isAddTested || !isSubTested|| !isMulTested || !isDivTested) {

            Task task = taskGenerator.generateTask();

            switch (task.getOperationSymbol()) {
                case "+":
                    assertTrue(task.getNum1() >= 0 && task.getNum1() < 100);
                    assertTrue(task.getNum2() >= 0 && task.getNum2() < 100);
                    assertTrue(task.getResult() >= 21 && task.getResult() < 100);
                    assertEquals(task.getNum1() + task.getNum2(), task.getResult());
                    isAddTested = true;
                    break;
                case "-":
                    assertTrue(task.getNum1() >= 21 && task.getNum1() < 100);
                    assertTrue(task.getNum2() >= 0 && task.getNum2() <= task.getNum1() - 21);
                    assertTrue(task.getResult() >= 21 && task.getResult() < 100);
                    assertEquals(task.getNum1() - task.getNum2(), task.getResult());
                    isSubTested = true;
                    break;
                case "*":
                    assertTrue(task.getNum1() >= 3 && task.getNum1() <= 12);
                    assertTrue(task.getNum2() >= 3 && task.getNum2() <= 12);
                    assertNotEquals(10, task.getNum1());
                    assertNotEquals(10, task.getNum2());
                    assertEquals(task.getNum1() * task.getNum2(), task.getResult());
                    isMulTested = true;
                    break;
                case "/":
                    assertTrue(task.getNum1() >= 9 && task.getNum1() <= 145);
                    assertTrue(task.getNum2() >= 9 && task.getNum2() <= 145);
                    assertTrue(task.getResult() >= 1 && task.getResult() <= 12);
                    assertEquals(task.getNum1() / task.getNum2(), task.getResult());
                    isDivTested = true;
                    break;
            }
        }
    }
}


