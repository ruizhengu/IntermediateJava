package uk.ac.sheffield.com1003.cafe.exceptions;

/** Thrown when the cafe can't take any more orders. */
public class CafeOutOfCapacityException extends Exception {
    public CafeOutOfCapacityException() {
        super();
    }
}
