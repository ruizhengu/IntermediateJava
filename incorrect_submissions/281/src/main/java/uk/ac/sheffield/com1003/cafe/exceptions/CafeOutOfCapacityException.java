package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {
    public CafeOutOfCapacityException() {
        super("The cafe currently can't handle any more orders");
    }
}
