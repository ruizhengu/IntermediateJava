package uk.ac.sheffield.com1003.cafe.solution.exceptions;
/**
 * The RecipeNotFoundException class is an exception that is thrown when a recipe cannot be found in the cafe's recipe book.
 * This exception can be thrown by methods that search for a recipe in the cafe's inventory, such as when a customer places
 * an order for a drink that is not listed on the menu or when a manager tries to remove a recipe from the recipe book.
 */
public class RecipeNotFoundException extends Exception {
}