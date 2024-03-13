package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception{
    public RecipeNotFoundException (String recipeName ) {
        System.out.println(recipeName + " Recipe not found.");

    }
}
