package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
    private String message;

    public TooManyIngredientsException(String message) { this.message = message;}

    public String getMessage() { return message; }
    
}
