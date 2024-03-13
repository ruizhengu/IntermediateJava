package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {
        // Task 1
        Cafe cafe = new Cafe();
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            cafe.addRecipe(espresso);
            System.out.println("Added " + espresso.getName());

            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);
            System.out.println("Added " + doubleEspresso.getName());

            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Milk(100, Type.SOY));
            largeSoyLatte.addIngredient(new Water(300));
            cafe.addRecipe(largeSoyLatte);
            System.out.println("Added " + largeSoyLatte.getName());

            // Task 2
            cafe.printMenu();
        } catch(TooManyIngredientsException e) {
            System.out.println("Too many ingredients were added to a recipe");
        }
    }
}
