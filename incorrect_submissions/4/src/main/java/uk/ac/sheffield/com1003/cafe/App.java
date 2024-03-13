package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) {
        // Creates 3 recipes and initializes the cafe
        Recipe espresso = new Recipe("Espresso", 1.5);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5);
        Cafe cafe = new Cafe();
        
        // Adds ingredients to recipes. Catches too many ingredients exception too
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        try {
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Water());
            largeSoyLatte.addIngredient(new Milk(100, Type.SOY));
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        // Adds recipes to cafe
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);
    }
}
