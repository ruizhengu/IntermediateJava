package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
        public static void main(String[] args) {
            // Create Cafe instance
            Cafe cafe = new Cafe("M's Cafe");


            // Create the Espresso recipe
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            try {
                //Add water and coffee to the espresso
                espresso.addIngredient(new Coffee());
                espresso.addIngredient(new Water());
            } catch (TooManyIngredientsException e) {
                System.out.println("This recipe has too many ingredients");
            }
            // Add Espresso Recipe to Cafe
            cafe.addRecipe(espresso);


            // Create the Double Espresso recipe
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);

            try {
                doubleEspresso.addIngredient(new Coffee(15));
                doubleEspresso.addIngredient(new Milk(50));

            } catch (TooManyIngredientsException e) {
                System.out.println("Too many ingredients in this recipe");
            }
            cafe.addRecipe(doubleEspresso);

            // Create the Large Soy Latte recipe
            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
            try {
                largeSoyLatte.addIngredient(new Coffee(30));
                largeSoyLatte.addIngredient(new Milk(50, Milk.Type.SOY));
                largeSoyLatte.addIngredient(new Water(10));

            } catch (TooManyIngredientsException e) {
                System.out.println("Too many ingredients in this recipe");
            }
              cafe.addRecipe(largeSoyLatte);

            //Print menu method
            cafe.printMenu();

        }
}

