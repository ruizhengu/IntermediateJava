package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;




//created the App class.
public class App {
        public static void main(String[] args) {
            Cafe cafe = new Cafe ();

            // Creating the code for the Espresso recipe
            Recipe espresso = new Recipe ("Espresso", 1.5, Recipe.Size.SMALL, 2);
            try {
                espresso.addIngredient ( new Coffee (8) );
                espresso.addIngredient (new Water (30) );
            } catch ( TooManyIngredientsException e ) {
                System.out.println("Error: " + e.getMessage());;
            }
            cafe.addRecipe ( espresso );
            // Creating the code for the Double Espresso recipe
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2);
            try {
                doubleEspresso.addIngredient ( new Coffee ( 15) ) ;
                doubleEspresso.addIngredient ( new Water( 50) );
            } catch ( TooManyIngredientsException e ) {
                System.out.println("Error: " + e.getMessage());;
            }
            cafe.addRecipe ( doubleEspresso );
            // Creating the code for the Large Soy Latte recipe
            Recipe largeSoyLatte = new Recipe ("large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
            try {
                largeSoyLatte.addIngredient( new Coffee (12) );
                largeSoyLatte.addIngredient ( new Water (30 ) );
                largeSoyLatte.addIngredient ( new Milk (200, Milk.Type.SOY ) );
            } catch ( TooManyIngredientsException e ) {
                System.out.println("Error: " + e.getMessage());;
            }
            cafe.addRecipe ( largeSoyLatte );







            // Print the menu
            cafe.printMenu ();





        }

}


