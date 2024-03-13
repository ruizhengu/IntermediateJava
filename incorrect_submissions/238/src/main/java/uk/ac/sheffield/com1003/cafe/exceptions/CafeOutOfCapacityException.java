/**
 * CafeOutOfCapacityException.java
 * This class defines a custom exception, CafeOutOfCapacityException, thrown when the cafe reaches max capacity.
 * @version 1.0 10/03/2023
 * @author Unknown
 */

package uk.ac.sheffield.com1003.cafe.exceptions;
public class CafeOutOfCapacityException extends Exception {

    /**
     * Constructs a CafeOutOfCapacityException with the specified detail message.
     * @param message the detail message
     */
    public CafeOutOfCapacityException(String message) {
        super(message);
    }
}



