package de.etamax.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Dusko Tesanovic
 */
public class TaskTest {

    /**
     *
     */
    @Test
    public void testDefaultConstructor() {
        Task task = new Task();

        assertEquals(0, task.getNum1());
        assertEquals(0, task.getNum2());
        assertNull(task.getOperationSymbol());
        assertEquals(0, task.getResult());
    }

    /**
     *
     */
    @Test
    public void testFullConstructor() {
        Task task = new Task(5, 21, "+", 26);

        assertEquals(5, task.getNum1());
        assertEquals(21, task.getNum2());
        assertEquals("+", task.getOperationSymbol());
        assertEquals(26, task.getResult());
    }

    /**
     *
     */
    @Test
    public void testGettersAndSetters() {
        Task task = new Task();
        task.setNum1(30);
        task.setNum2(3);
        task.setOperationSymbol("-");
        task.setResult(27);

        assertEquals(30, task.getNum1());
        assertEquals(3, task.getNum2());
        assertEquals("-", task.getOperationSymbol());
        assertEquals(27, task.getResult());
    }

    /**
     *
     */
    @Test
    public void testEquals() {
        Task task1 = new Task(20, 5, "+", 25);
        Task task2 = new Task(5, 20, "+", 25);
        Task task3 = new Task(20, 5, "+", 25);
        Task task4 = new Task(40, 20, "+", 60);
        Task task5 = new Task(3, 5, "*", 15);
        Task task6 = new Task(5, 3, "*", 15);
        Task task7 = new Task(5, 5, "*", 25);

        assertEquals(task1, task2);
        assertEquals(task1, task3);
        assertNotEquals(task1, task4);
        assertEquals(task5, task6);
        assertNotEquals(task5, task7);
    }

    /**
     *
     */
    @Test
    public void testHashCode() {
        Task task1 = new Task(20, 5, "/", 4);
        Task task2 = new Task(5, 20, "/", 4);
        Task task3 = new Task(20, 5, "/", 4);

        assertNotEquals(task1.hashCode(), task2.hashCode());
        assertEquals(task1.hashCode(), task3.hashCode());
    }
}
