package uk.ac.sheffield.com1003.cafe.exceptions;

import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;

public class TooManyIngredientsException extends Exception {
  Ingredient ingredient;
  /**
   * Exception is thrown when ingredient is trying to be added to full
   * ingredients list.
   */
    public TooManyIngredientsException(Ingredient ing){
      this.ingredient = ing;
    }

  public Ingredient getIngredient() {
    return ingredient;
  }
}
