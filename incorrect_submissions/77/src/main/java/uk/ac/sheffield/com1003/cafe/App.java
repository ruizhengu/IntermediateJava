package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args){
        // Create the cafe
        Cafe myCafe = new Cafe();
        // Create the recipes
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        // Add ingredients to recipes
        try{
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e){
            System.out.println("Could not add ingredient to espresso: all ingredients are already set!");
            e.printStackTrace();
        }
        try{
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e){
            System.out.println("Could not add ingredient to double espresso: all ingredients are already set!");
            e.printStackTrace();
        }
        try{
            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Milk(15, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Syrup(1, "Maple"));
        } catch(TooManyIngredientsException e){
            System.out.println("Could not add ingredient to soy latte: all ingredients are already set!");
            e.printStackTrace();
        }
        // Add recipes to cafe
        myCafe.addRecipe(espresso);
        myCafe.addRecipe(doubleEspresso);
        myCafe.addRecipe(largeSoyLatte);

        // Print cafe menu
        myCafe.printMenu();
    }
}
