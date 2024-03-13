package uk.ac.sheffield.com1003.cafe.exceptions;

public class RecipeNotFoundException extends Exception {
    public RecipeNotFoundException(){
        System.out.println("Error: The given name of the order does not exist in the menu");
    }
}
