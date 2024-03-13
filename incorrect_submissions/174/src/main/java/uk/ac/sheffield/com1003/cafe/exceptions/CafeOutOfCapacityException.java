package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {
    private int orderNum;

    public CafeOutOfCapacityException(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public int getValue() {
        return orderNum;
    }
}
