package uk.ac.sheffield.com1003.cafe.exceptions;

@SuppressWarnings("serial")
public class TooManyIngredientsException extends Exception {
    

    /**
     * @param ingredientSize refers to the defined size of ingredients for the addressed recipe
     * printing a statement which tells user to cross-check their input on main method (App.java) 
     */
    public TooManyIngredientsException(int ingredientSize) {
        System.out.println("The ingredients exceed value of " + ingredientSize +  ". Please check your defined numberOfIngredients value and .addIngredient() method calls and re-run the code.");
    }
}
