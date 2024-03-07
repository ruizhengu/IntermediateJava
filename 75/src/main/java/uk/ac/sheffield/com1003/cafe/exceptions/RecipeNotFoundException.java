package uk.ac.sheffield.com1003.cafe.exceptions;

/**
 * Throws an exception when a provided recipe name does not match that of a stored recipe
 */
public class RecipeNotFoundException extends Exception {
    private String recipeName;

    /**
     * Constructs a new RecipeNotFoundException.
     * @param recipeName Name of the non-existent recipe
     */
    public RecipeNotFoundException(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }
    
}
