package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception{

    @Override
    public String toString() {
        return "Recipe Not Found!!";
    }

    @Override
    public String getMessage() {
        return "Recipe Not Found!!";
    }
}
