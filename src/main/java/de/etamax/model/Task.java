package de.etamax.util;

import java.util.Objects;

public class Task {

    int num1;
    int num2;
    String operationSymbol;
    int result;


    public Task() {
    }

    public Task(int num1, int num2, String operationSymbol, int result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operationSymbol = operationSymbol;
        this.result = result;
    }

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

    @Override
    public String toString() {
        return "Task{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operationSymbol='" + operationSymbol + '\'' +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Task)) {
            return false;
        }

        Task task = (Task) o;

        if (getNum1() == task.getNum2() &&
                getNum2() == task.getNum1() &&
                getResult() == task.getResult() &&
                operationSymbol.equals(task.operationSymbol)) {
            return true;
        }

        return getNum1() == task.getNum1() &&
                getNum2() == task.getNum2() &&
                getResult() == task.getResult() &&
                operationSymbol.equals(task.operationSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNum1(), getNum2(), operationSymbol, getResult());
    }
}
