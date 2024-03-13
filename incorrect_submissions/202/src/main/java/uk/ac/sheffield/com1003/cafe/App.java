package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;



public class App {
    public static void main(String[] args) {
        //Cafe instance

        Cafe cafe = new Cafe();

        // Create Espresso recipe

        try {
            Recipe espresso = new Recipe("Espresso", 1.5,  Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            cafe.addRecipe(espresso);
        } catch (TooManyIngredientsException e) {
            System.err.println("Error: Too many ingredients in the recipe.");
        }
        // Create Double Espresso recipe
        try {
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);
        } catch (TooManyIngredientsException e) {
            System.err.println("Error: Too many ingredients in the recipe.");
        }
        
        // Create Large Soy Latte recipe
        try {
            Milk soyMilk = new Milk( 50, Milk.Type.SOY);
            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3 );
            largeSoyLatte.addIngredient(new Coffee(15, false));
            largeSoyLatte.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(soyMilk);
            cafe.addRecipe(largeSoyLatte);
        } catch (TooManyIngredientsException e) {
            System.err.println("Error: Too many ingredients in the recipe.");
        }

        cafe.printMenu();
    }
       
}



