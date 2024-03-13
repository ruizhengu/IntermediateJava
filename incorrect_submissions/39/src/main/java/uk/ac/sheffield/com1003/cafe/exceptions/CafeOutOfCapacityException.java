package uk.ac.sheffield.com1003.cafe.exceptions;

public class CafeOutOfCapacityException extends Exception{
    private String recipe;
    public CafeOutOfCapacityException(String recipe){
        this.recipe = recipe;
    }
    public String getRecipe(){
        return recipe;
    }
}
