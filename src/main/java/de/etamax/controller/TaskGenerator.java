package de.etamax.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TaskGenerator {

    int num1;
    int num2;
    String operator;
    int result;
    List<String> operators = Arrays.asList("Add", "Sub", "Mul", "Div");
    List<Integer> multiplicationNumbs = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 11, 12);
    Task newTask;
    Random random = new Random();

    /**
     * The method calls another method for generating a task regarding
     * chosen operation. Switch construction and random chosen operation value in array list is used for decision which kind of operation will be applied in new task.
     *
     * @return a new generated object type Task with random chosen operation
     */
    public Task generateTask() {
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
        num1 = random.nextInt(100);
        num2 = random.nextInt(99-num1+1);
        num2 = Math.max(21-num1, num2);
        operator = "+";
        result = num1 + num2;

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
        num1 = random.nextInt(100);
        num1 = Math.max(num1, 21);
        num2 = random.nextInt(num1 - 21 + 1);
        operator = "-";
        result = num1 + num2;

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
        operator = "*";
        num1 = multiplicationNumbs.get(random.nextInt(9));
        num2 = multiplicationNumbs.get(random.nextInt(9));
        result = num1 * num2;

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
        operator = "/";
        num1 = random.nextInt(145);
        num1 = Math.max(num1, 9);
        num2 = random.nextInt(145);
        num2 = Math.max(num2, 9);
        result = num1 / num2;
        if (num2 > num1 || num1 % num2 != 0 || !multiplicationNumbs.contains((Integer) result)) {
            return divTaskGenerator();
        }

        return new Task(num1, num2, operator, result);
    }
}


