package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.Recipe;

public class RecipeNotFoundException extends Exception {
    private String name;

    public RecipeNotFoundException(String name) {
        super(name);
    }

    public String getName() {
        return name + " is not found on the menu";
    }
}
