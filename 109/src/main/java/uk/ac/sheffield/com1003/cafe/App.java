package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe("The Roost");

        try {
            Recipe espresso =
                    new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            Recipe doubleEspresso =
                    new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

            Recipe largeSoyLatte =
                    new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
            largeSoyLatte.addIngredient(new Milk(151, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Coffee(139));
            largeSoyLatte.addIngredient(new Water());


            cafe.addRecipe(espresso);
            cafe.addRecipe(doubleEspresso);
            cafe.addRecipe(largeSoyLatte);

            cafe.printMenu();

        } catch (TooManyIngredientsException e) {
            System.out.println("One (or many) of the recipes added has more ingredients than necessary.");
        }
    }
}
