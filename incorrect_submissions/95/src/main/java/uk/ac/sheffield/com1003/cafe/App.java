package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

/**
 * App class which provides the functionality of creating a Cafe instance, creating 
 * Recipe instances, adding ingredients to the recipes, adding recipes to the menu,
 * and printing out the menu.
 * @throws TooManyIngredientsException if the recipe contains more than the specified numbers of ingredients
 * @throws RecipeNotFoundException if the recipe is not found on the Cafe menu
 * @throws CafeOutOfCapacityException if the Cafe is out of capacity
 */
public class App {

        public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {

            //Cafe instance and Recipe instances
            Cafe cafe = new Cafe();
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE,3 );

            //Code to add ingredients to their respective recipes
            // Espresso
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            // Double Espresso
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

            // Large Soy Latte
            largeSoyLatte.addIngredient ( new Milk (20,Milk.Type.SOY ) );
            largeSoyLatte.addIngredient ( new Water () );
            largeSoyLatte.addIngredient ( new Coffee () );

            //Code to add recipes to the menu
            cafe.addRecipe(espresso);
            cafe.addRecipe(doubleEspresso);
            cafe.addRecipe(largeSoyLatte);        

            //Code to print out the menu
            cafe.printMenu();

        }

    }
