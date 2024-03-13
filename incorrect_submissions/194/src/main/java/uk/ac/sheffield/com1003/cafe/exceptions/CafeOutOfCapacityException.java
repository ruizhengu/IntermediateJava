package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Cafe;

/**
 * Exception thrown whenever maximum number of orders for a cafe is exceeded.
 * @author milan
 */
public class CafeOutOfCapacityException extends Exception {
    public CafeOutOfCapacityException() {
        System.out.println("Maximum number of orders has been exceeded");
    }

}
