package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
    private int numOfIngredient;
    private String recipeName;

    public TooManyIngredientsException(int numOfIngredient, String recipeName){
        this.numOfIngredient = numOfIngredient;
        this.recipeName = recipeName;
    }

    public int getNumOfIngredient(){
        return numOfIngredient;
    }

    public String getRecipeName(){
        return recipeName;
    }
}
