package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception{
    
    private String recipe;

    /**
     * returns a more precise error message telling the user what caused this error
     * 
     * @param r the recipe name that couldn't be found
     */
    public RecipeNotFoundException(String r) {
        this.recipe = r;
        System.out.println("Sorry! " + this.recipe + " couldn't be found in the menu.");
    }

}
