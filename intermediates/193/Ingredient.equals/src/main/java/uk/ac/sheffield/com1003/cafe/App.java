package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args)
            throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe();
        Recipe espresso = new Recipe("Espresso", 1.5);
        espresso.addIngredient(new Coffee(8, false));
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);
        Ingredient doubleEspressoCoffee = new Coffee(15);
        Ingredient doubleEspressoWater = new Water(50);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2);
        cafe.addRecipe(doubleEspresso);
        Ingredient soyMilk = new Milk(100, Type.SOY);
        Ingredient largeLatteCoffee = new Coffee(15);
        Ingredient largeLatteWater = new Water(60);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5);
        cafe.addRecipe(largeSoyLatte);
        cafe.printMenu();

    }
}
