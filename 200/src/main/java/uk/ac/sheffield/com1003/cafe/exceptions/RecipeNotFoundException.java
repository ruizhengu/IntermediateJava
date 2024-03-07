package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception{

    public RecipeNotFoundException() {
        System.out.println("Recipe not found");
    }

}
