package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception{

    public RecipeNotFoundException(String string) {
    
    }

    public String toString() {
        return ("Recipe does not exist in the menu");
    }

}
