package uk.ac.sheffield.com1003.cafe.solution.exceptions;
/**
 * Task 3 - Checked exception thrown when a recipe is not found in a cafe object
 *
 * @version 1.3 16/03/2023
 * @since 0.3
 * @author unknown
 */
public class RecipeNotFoundException extends Exception {

  /**
   * Constructor that sets the Exception message to show which recipe was not found
   * @param recipeString the name of the recipe that was searched for
   */
  public RecipeNotFoundException(String recipeString) {
    super(recipeString + " not found");
  }
}
