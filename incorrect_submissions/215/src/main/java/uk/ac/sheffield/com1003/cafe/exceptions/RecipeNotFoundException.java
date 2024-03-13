package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception{
    private String message;

    public RecipeNotFoundException(String message) { this.message = message;}

    public String getMessage() { return message; }

}
