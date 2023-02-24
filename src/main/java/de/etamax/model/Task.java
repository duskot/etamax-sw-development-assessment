package de.etamax.model;

import java.util.Objects;

/**
 * This class represents a mathematical task with two operands,
 * an operation symbol, and a result.
 *
 * @author Dusko Tesanovic
 */
public class Task {

    // declare class variables
    int num1;
    int num2;
    String operationSymbol;
    int result;

    // constructors default and parametrised
    public Task() {
    }

    public Task(int num1, int num2, String operationSymbol, int result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operationSymbol = operationSymbol;
        this.result = result;
    }

    // getters and setters
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperationSymbol() {
        return operationSymbol;
    }

    public void setOperationSymbol(String operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    /**
     * This override methode checks is this object same as passed.
     *
     * @param o the passed object to be checked
     * @return the boolean value
     */
    @Override
    public boolean equals(Object o) {
        // check type of passed object
        if (!(o instanceof Task)) {
            return false;
        }

        // instance task object
        Task task = (Task) o;

        // check object commutativity
        if (getNum1() == task.getNum2() &&
                getNum2() == task.getNum1() &&
                getResult() == task.getResult() &&
                operationSymbol.equals(task.operationSymbol)) {
            return true;
        }

        // check is object identical and return
        return getNum1() == task.getNum1() &&
                getNum2() == task.getNum2() &&
                getResult() == task.getResult() &&
                operationSymbol.equals(task.operationSymbol);
    }

    /**
     * This override methode return hash code of this object.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(getNum1(), getNum2(), operationSymbol, getResult());
    }
}
