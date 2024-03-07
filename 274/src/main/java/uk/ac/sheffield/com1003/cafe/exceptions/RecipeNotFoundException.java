package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception{
    public RecipeNotFoundException(){
        super("The recipe could not be found");
    }
}
