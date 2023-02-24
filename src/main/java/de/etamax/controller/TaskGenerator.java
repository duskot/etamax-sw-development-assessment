package de.etamax.controller;

import de.etamax.model.Task;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class generates a new task regarding the chosen arithmetic
 * operation. The class includes four methods for generating tasks
 * that are used based on a switch statement that uses a random
 * index for the arithmetic operations.
 *
 * @author Dusko Tesanovic
 */
public class TaskGenerator {

    // declare and initialise class objects and variables
    int num1;
    int num2;
    String operator;
    int result;
    // define the list od mathematics operators
    List<String> operators = Arrays.asList("Add", "Sub", "Mul", "Div");
    // define the list od allowed numbers for multiplication
    List<Integer> multiplicationNumbs = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 11, 12);
    Task newTask;
    Random random = new Random();

    /**
     * The method calls another method for generating a task regarding
     * chosen operation. Switch statement and random chosen operation
     * value in array list is used for decision which kind of operation
     * will be applied in new task.
     *
     * @return a new generated object type Task with random chosen operation
     */
    public Task generateTask() {
        // generate random operation and call proper methode for task generation
        switch (operators.get(random.nextInt(4))) {
            case "Add":
                newTask = addTaskGenerator();
                break;
            case "Sub":
                newTask = subTaskGenerator();
                break;
            case "Mul":
                newTask = mulTaskGenerator();
                break;
            case "Div":
                newTask = divTaskGenerator();
                break;
        }

        // return new generated task
        return newTask;
    }

    /**
     * The method generates a new task for the addition operation.
     * All variables are of type int. Each operand is chosen randomly.
     * The first operand is chosen in the range from 0 to 99,
     * and the second operand is chosen using a reduced range depending
     * on the first chosen operand. Result variable is in range of 21 to 99.
     *
     * @return a new generated object type Task with an addition operation
     */
    private Task addTaskGenerator() {
        // assign corresponding operator
        operator = "+";
        // generate first operand random in range of 0 to 99
        num1 = random.nextInt(100);
        // generate second operand random in reduced range
        // to match result requirement in range of 21 to 99
        num2 = random.nextInt(99-num1+1);
        num2 = Math.max(21-num1, num2);
        // calculate result
        result = num1 + num2;

        // return new task
        return new Task(num1, num2, operator, result);
    }

    /**
     * The method generates a new task for the subtraction operation.
     * All variables are of type int. Each operand is chosen randomly.
     * The first operand is chosen in the range from 21 to 99,
     * and the second operand is chosen using a reduced range depending
     * on the first chosen operand. Result variable is in range of 21 to 99.
     *
     * @return a new generated object type Task with a subtraction operation
     */
    private Task subTaskGenerator() {
        // assign corresponding operator
        operator = "-";
        // generate first operand random in range of 21 to 99
        num1 = random.nextInt(100);
        num1 = Math.max(num1, 21);
        // generate second operand random in reduced range
        // to match result requirement in range of 21 to 99
        num2 = random.nextInt(num1 - 21 + 1);
        // calculate result
        result = num1 - num2;

        // return new task
        return new Task(num1, num2, operator, result);
    }

    /**
     * The method generates a new task for the division operation.
     * All variables are of type int and each operand is chosen randomly
     * from predefined values which are stored in the array list.
     *
     * @return a new generated object type Task with a multiplication operation
     */
    private Task mulTaskGenerator() {
        // assign corresponding operator
        operator = "*";
        // generate first operand randomly taking from predefined list
        num1 = multiplicationNumbs.get(random.nextInt(9));
        // generate second operand randomly taking from predefined list
        num2 = multiplicationNumbs.get(random.nextInt(9));
        // calculate result
        result = num1 * num2;

        // return new task
        return new Task(num1, num2, operator, result);
    }

    /**
     * The method generates a new task for the multiplication operation.
     * All variables are of type int and each operand is chosen randomly
     * in the range from 9 to 145. The result has to match a value from
     * the array list which contained predefined values.
     *
     * @return a new generated object type Task with a division operation
     */
    private Task divTaskGenerator() {
        // assign corresponding operator
        operator = "/";
        num1 = random.nextInt(145);
        num1 = Math.max(num1, 9);
        num2 = random.nextInt(145);
        num2 = Math.max(num2, 9);
        // calculate result
        result = num1 / num2;
        // check divisibility of generated operands
        if (num2 > num1 || num1 % num2 != 0 || !multiplicationNumbs.contains((Integer) result)) {
            // recursive call if generated operands not divisible
            return divTaskGenerator();
        }

        // return new task
        return new Task(num1, num2, operator, result);
    }
}


