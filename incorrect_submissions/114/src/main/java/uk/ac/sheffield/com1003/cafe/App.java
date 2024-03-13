package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App{
    public static void main(String args[]){

        Cafe cafe = new Cafe();

        // Create recipe - Espresso
        Recipe espressoRec = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espressoRec.addIngredient(new Coffee());
            espressoRec.addIngredient(new Water());
            // Adding recipe to the menu
            cafe.addRecipe(espressoRec);
        } catch (TooManyIngredientsException e) {
            System.out.println("There are too many ingredients");
        }

        // Create recipe - Double Espresso
        Recipe doubleEspressoRec = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspressoRec.addIngredient(new Coffee(15));
            doubleEspressoRec.addIngredient(new Water(50));
            // Adding recipe to the menu
            cafe.addRecipe(doubleEspressoRec);
        } catch (TooManyIngredientsException e) {
            System.out.println("There are too many ingredients");
        }

        // Create recipe - Large Soy Latte
        Recipe largeSoyLatteRec = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        try {
            largeSoyLatteRec.addIngredient(new Coffee(20));
            largeSoyLatteRec.addIngredient(new Milk(130, Milk.Type.SOY));
            // Adding recipe to the menu
            cafe.addRecipe(largeSoyLatteRec);
        } catch (TooManyIngredientsException e) {
            System.out.println("There are too many ingredients");
        }

        cafe.printMenu();

    }
}