package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception {
    /* Outputs message if the cafe's capacity is full */
    public CafeOutOfCapacityException(String message) {
        super(message);
    }

}
