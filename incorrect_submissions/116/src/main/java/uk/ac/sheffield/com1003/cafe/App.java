package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

import uk.ac.sheffield.com1003.cafe.Recipe;

public class App {
    /**
     * Add Espresso, Double Espresso and Large Soy Latte
     * to the <Cafe cafe>
     * @param cafe the cafe to be modified
     * @return an updated version of cafe 
     */
    private static Cafe make_menu(Cafe cafe) throws TooManyIngredientsException{
        // Espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);

        // Double Espresso
        Recipe double_espresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        double_espresso.addIngredient(new Coffee(15));
        double_espresso.addIngredient(new Water(50));
        cafe.addRecipe(double_espresso);

        // Large Soy Latte
        Recipe large_soy_latte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        large_soy_latte.addIngredient(new Coffee(20));
        large_soy_latte.addIngredient(new Water(25));
        large_soy_latte.addIngredient(new Milk(75, Milk.Type.SOY));
        cafe.addRecipe(large_soy_latte);

        return cafe;
    }

    public static void main(String[] args) throws TooManyIngredientsException, CafeOutOfCapacityException, RecipeNotFoundException {
        Cafe cafe = new Cafe("My Cafe");

        cafe = make_menu(cafe);
        cafe.printMenu();
    }   
}
