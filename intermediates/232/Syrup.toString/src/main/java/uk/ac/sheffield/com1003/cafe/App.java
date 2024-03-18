package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

    /**
     * Creates a new instance of the cafe and 3 new recipes to go on the menu
     * ingredients are added to each recipe, if a too many ingredients exception is thrown then the program will stop
     * and the error message shown will print
     * all 3 recipes are then added to the menu and the menu is printed
     */
    public static void main(String[] args) throws TooManyIngredientsException, CafeOutOfCapacityException,
            RecipeNotFoundException {
        Cafe cafe = new Cafe();
        Recipe espresso = new Recipe("Espresso",1.50, Recipe.Size.SMALL,2);
        Recipe twoEspresso = new Recipe("Double Espresso",2.20, Recipe.Size.REGULAR,2);
        Recipe lSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE,3);
        try {
            espresso.addIngredient(new Water());
            espresso.addIngredient(new Coffee());
            twoEspresso.addIngredient(new Water(50));
            twoEspresso.addIngredient(new Coffee(15, false));
            lSoyLatte.addIngredient(new Milk(110, Milk.Type.SOY));
            lSoyLatte.addIngredient(new Coffee(30, false));
            lSoyLatte.addIngredient(new Water(100));
        } catch (TooManyIngredientsException e) {
            System.err.println("Too many ingredients added!");
        }
        cafe.addRecipe(espresso);
        cafe.addRecipe(twoEspresso);
        cafe.addRecipe(lSoyLatte);
        cafe.printMenu();

    }
}
