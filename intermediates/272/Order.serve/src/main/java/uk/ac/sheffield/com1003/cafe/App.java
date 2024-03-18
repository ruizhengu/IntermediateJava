package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    
    public static void main(String[] args) throws TooManyIngredientsException, CafeOutOfCapacityException, RecipeNotFoundException {        
        Cafe shop = new Cafe();

        // Recipes
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);

        // Appending Recipes
        shop.addRecipe(espresso);
        shop.addRecipe(doubleEspresso);
        shop.addRecipe(largeSoyLatte);

        // Ingredients
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());

        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));

        largeSoyLatte.addIngredient(new Coffee(12));
        largeSoyLatte.addIngredient(new Milk(50, Type.SOY));
    }

}
