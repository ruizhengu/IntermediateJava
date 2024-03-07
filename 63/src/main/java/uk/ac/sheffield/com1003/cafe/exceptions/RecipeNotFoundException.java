package uk.ac.sheffield.com1003.cafe.exceptions;
public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(String s) {
        super(s);
    }
}
