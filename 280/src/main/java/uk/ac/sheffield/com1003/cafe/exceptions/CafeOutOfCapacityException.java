package uk.ac.sheffield.com1003.cafe.exceptions;
/**
 * if the maximum number of orders for the cafe has been exceeded
 * @author Nur Izfarwiza
 *
 */
@SuppressWarnings("serial")
public class CafeOutOfCapacityException extends Exception{
	private String message;

    // Constructor that takes a message parameter
    public CafeOutOfCapacityException(String message) {
        this.message = message;
    }
    // Getter method to retrieve the error message
    public String getMessage() {
        return message;
    }

}
