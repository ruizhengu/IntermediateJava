package uk.ac.sheffield.com1003.cafe.exceptions;

/**
 * An exception that gets thrown if, when searching for a recipe in a recipe list (e.g. Cafe's menu),
 * none are found matching the given name.
 * Stores the invalid recipe name for use in exception handling.
 */
public class RecipeNotFoundException extends Exception {

    private final String invalidRecipeName;

    public RecipeNotFoundException(String invalidRecipeName) {
        this.invalidRecipeName = invalidRecipeName;
    }

    public String getInvalidRecipeName() {
        return invalidRecipeName;
    }
}
