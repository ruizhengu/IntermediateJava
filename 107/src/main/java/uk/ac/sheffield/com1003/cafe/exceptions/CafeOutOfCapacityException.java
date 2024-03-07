package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception{
    private int value;

    public CafeOutOfCapacityException(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
