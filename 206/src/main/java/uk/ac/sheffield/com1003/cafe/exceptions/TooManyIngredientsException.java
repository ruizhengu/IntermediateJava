package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
    private int maxIngredients;
    public TooManyIngredientsException(int maxIngredients){
        this.maxIngredients = maxIngredients;
    }

    public int getMaxIngredients(){
        return maxIngredients;
    }

    
}
