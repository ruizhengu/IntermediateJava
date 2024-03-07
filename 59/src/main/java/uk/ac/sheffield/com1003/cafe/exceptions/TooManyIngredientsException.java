package uk.ac.sheffield.com1003.cafe.exceptions;

public class TooManyIngredientsException extends Exception {
    public TooManyIngredientsException(){
        System.out.println("No space for another ingredient in the recipe.");
    }
}
