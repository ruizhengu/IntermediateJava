package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception{
    // Variable to store the recipe that was NOT available
    private String recipeName;

    public RecipeNotFoundException(String name){
        this.recipeName = name;
    }
}
