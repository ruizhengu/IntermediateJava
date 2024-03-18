package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

/**
 * The App class is the main class of the application. It is responsible for
 * creating the cafe and the recipes, and adding the recipes to the cafe.
 *
 * @author Xinye Yang
 *
 */
public class App {
    public static void main(String[] args) {

        // Create a new cafe
        Cafe cafe = new Cafe();

        // new recipe for a small espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Water());
            espresso.addIngredient(new Coffee(8, false));
        } catch (TooManyIngredientsException e) {
            // If number of ingredients exceeds the maximum allowed, print the error
            System.out.println("Too many ingredients for espresso!");
        }
        // Add the recipe to the cafe
        if(!cafe.addRecipe(espresso)){
            System.out.println("espresso could not be added to the menu!");
        } else {
            System.out.println("espresso added to the menu!");
        }


        //new recipe for a regular Double Espresso
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            // If number of ingredients exceeds the maximum allowed, print the error
            System.out.println("Too many ingredients for double espresso!");
        }
        // Add the recipe to the cafe
        if(!cafe.addRecipe(doubleEspresso)){
            System.out.println("doubleEspresso could not be added to the menu!");
        } else {
            System.out.println("doubleEspresso added to the menu!");
        }

        //new recipe a Large Soy Latte
        Recipe soyLatte = new Recipe("Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        try {
            soyLatte.addIngredient(new Milk(50, Milk.Type.SOY));
            soyLatte.addIngredient(new Coffee(25));
        } catch (TooManyIngredientsException e) {
            // If number of ingredients exceeds the maximum allowed, print the error
            System.out.println("Too many ingredients for soy latte!");
        }
        // Add the recipe to the cafe
        if(!cafe.addRecipe(soyLatte)){
            System.out.println("soyLatte could not be added to the menu!");
        } else {
            System.out.println("soyLatte added to the menu!");
        }

        cafe.printMenu();

}

}