package uk.ac.sheffield.com1003.cafe.exceptions;

/**
 * This exception is thrown when the user attempts to order when the cafe has
 * reached its limit.
 */

public class CafeOutOfCapacityException extends Exception {

    @Override
    public String toString() {
        return "The cafe is currently out of capacity,do check back later!";
    }
}
