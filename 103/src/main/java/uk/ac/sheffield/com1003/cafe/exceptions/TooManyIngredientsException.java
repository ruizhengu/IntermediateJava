package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
    @Override
    public String toString() {
        return "Too Many Ingredients Exception";
    }

    @Override
    public String getMessage() {
        return "Too Many Ingredients Exception";
    }
}
