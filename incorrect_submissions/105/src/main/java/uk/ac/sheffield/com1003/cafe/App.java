package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException {
        // Create a new Cafe instance
        Cafe cafe = new Cafe("Nihal's Cafe");

        // Create three Recipe instances for drinks
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee(8, false));
        espresso.addIngredient(new Water(30));
        cafe.addRecipe(espresso);


        Recipe doubleEspresso = new Recipe("DoubleEspresso", 2.2, Recipe.Size.REGULAR , 2);
        doubleEspresso.addIngredient(new Coffee(15, false));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
        largeSoyLatte.addIngredient(new Water());
        largeSoyLatte.addIngredient(new Syrup(50));
        cafe.addRecipe(largeSoyLatte);

    }
}


