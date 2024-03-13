package uk.ac.sheffield.com1003.cafe.exceptions;

/** Represents an invalid operation due to the cafe running out of order capacity.
 * @author Samuel Taseff
 */
public class CafeOutOfCapacityException extends Exception {
    public CafeOutOfCapacityException(String msg) {
        super(msg);
    }
}
