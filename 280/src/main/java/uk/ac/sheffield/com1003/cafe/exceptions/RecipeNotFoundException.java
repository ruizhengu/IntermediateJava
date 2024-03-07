package uk.ac.sheffield.com1003.cafe.exceptions;

/**
 * This is an exception class if the recipe name received as argument
 * does not exist in the menu
 * @author Nur Izfarwiza
 *
 */
@SuppressWarnings("serial")
public class RecipeNotFoundException extends Exception {
	private String message;

    // Constructor that takes a message parameter
    public RecipeNotFoundException(String message) {
        this.message = message;
    }

    // Getter method to retrieve the error message
    public String getMessage() {
        return message;
    }
	
}
