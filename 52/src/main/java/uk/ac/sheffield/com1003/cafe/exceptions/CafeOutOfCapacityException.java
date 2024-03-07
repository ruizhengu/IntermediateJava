package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {
    public CafeOutOfCapacityException() {
        System.out.println("The cafe is unable to deal with so many orders!");
    }

    public CafeOutOfCapacityException(String message) {
        super(message);
    }
}
