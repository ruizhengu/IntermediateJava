package uk.ac.sheffield.com1003.cafe.exceptions;

/**
 * Throws an exception when there is an attempt to add a new order to the cafe when 
 * the cafe is out of capacity
 */
public class CafeOutOfCapacityException extends Exception {

    /**
     * Constructs a new CafeOutOfCapacityException.
     */
    public CafeOutOfCapacityException() {

    }
    
}
