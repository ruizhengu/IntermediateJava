package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;


public class App {

    public static void main(String[] args) throws RecipeNotFoundException, CafeOutOfCapacityException{

        // Cafe instance
        Cafe shop = new Cafe("Central Perk", 10, 100);

        // Espresso coffee instance
        Recipe coffee1 = new Recipe( "Espresso" , 1.50 , Size.SMALL , 2 );
        // try and catch which adds amounts to the espresso or else throws an exception
        try {
            coffee1.addIngredient(new Coffee(8));
            coffee1.addIngredient(new Water(30));
        }
        catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients in the coffee");
        }
        // adds the recipe to the menu
        shop.addRecipe(coffee1);

        // Double Espresso instance
        Recipe coffee2 = new Recipe( "Double Espresso" , 2.20 , Size.REGULAR , 2 );
        // try and catch which adds amounts to the double espresso or else throws an exception
        try {
            coffee2.addIngredient(new Coffee(15));
            coffee2.addIngredient(new Water(50));
        }
        catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients in the coffee");
        }
        // adds the recipe to the menu
        shop.addRecipe(coffee2);
        
        // Large soy latte instance
        Recipe coffee3 = new Recipe( "Large Soy Latte" , 2.50 , Size.LARGE , 1);
        // try and catch which adds amounts to the Large Soy latte or else throws an exception
        try {
            coffee3.addIngredient(new Milk(15));
        }
        catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients in the coffee");
        }
        // adds the recipe to the menu
        shop.addRecipe(coffee3); 
    
        // prints the Menu
        shop.printMenu();


        
    }
    
}
