package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception{

    public RecipeNotFoundException(){
        super("Recipe not found");
    }

}