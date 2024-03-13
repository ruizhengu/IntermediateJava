package uk.ac.sheffield.com1003.cafe.exceptions;
/**
 * The CafeOutOfCapacityException class is an exception that is thrown when a cafe reaches its maximum capacity.
 * This exception can be thrown by methods that add new items to the cafe's inventory, such as when a new order
 * is placed.
 */
public class CafeOutOfCapacityException extends Exception {

    /**
     * Constructs a new CafeOutOfCapacityException object with no message.
     */
    public CafeOutOfCapacityException() {
        super();
    }

    /**
     * Constructs a new CafeOutOfCapacityException object with the specified message.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method)
     */
    public CafeOutOfCapacityException(String message) {
        super(message);
    }
}
