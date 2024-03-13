package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
public class App {

    public static void main(String[] args) {
        // creating a new cafe with a name size and capacity

        Cafe cafe = new Cafe("Saif's Cafe",10,100);

        // creating recipes while catching an exception of ingredients all the same

        Recipe Espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try{
            Espresso.addIngredient(new Water(30));
            Espresso.addIngredient(new Coffee(8));
            cafe.addRecipe(Espresso);
        } catch (TooManyIngredientsException e) {
            // Handle the exception
            System.err.println("Error: " + e.getMessage());
        }

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Water(50));
            doubleEspresso.addIngredient(new Coffee(15));
            cafe.addRecipe(doubleEspresso);
        }catch (TooManyIngredientsException e) {
    // Handle the exception
            System.err.println("Error: " + e.getMessage());
}
        Recipe LargeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);

        try{
            LargeSoyLatte.addIngredient(new Water(35));
            LargeSoyLatte.addIngredient(new Coffee(12));
            LargeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
            cafe.addRecipe(LargeSoyLatte);

        } catch (TooManyIngredientsException e) {
            // Handle the exception
            System.err.println("Error: " + e.getMessage());
        }

            cafe.printMenu();
    }
}


