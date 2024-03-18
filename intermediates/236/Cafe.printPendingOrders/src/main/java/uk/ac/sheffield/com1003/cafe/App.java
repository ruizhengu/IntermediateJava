package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

public class App {
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Ed's Cafe"); // make an instance of a cafe

        // make an instance of a recipe called espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);

        // add the ingredients to the espresso recipe
        try {
            espresso.addIngredient(new Water());
            espresso.addIngredient(new Coffee());
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients!");
        }

        // Add the recipe to the cafe menu
        myCafe.addRecipe(espresso);


        // make an instance of a recipe called doubleEspresso
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);

        // add the ingredients to the double espresso recipe
        try {
            doubleEspresso.addIngredient(new Water(50));
            doubleEspresso.addIngredient(new Coffee(15));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients!");
        }

        // Add the recipe to the cafe menu
        myCafe.addRecipe(doubleEspresso);

        // make an instance of a recipe called doubleEspresso
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);

        // add the ingredients to the double espresso recipe
        try {
            largeSoyLatte.addIngredient(new Water(40));
            largeSoyLatte.addIngredient(new Coffee(20));
            largeSoyLatte.addIngredient(new Milk(35, Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients!");
        }

        // Add the recipe to the cafe menu
        myCafe.addRecipe(largeSoyLatte);

        Recipe toffeeLatte = new Recipe("Toffee Latte", 1.8, Size.REGULAR, 4);

        try {
            toffeeLatte.addIngredient(new Water(30));
            toffeeLatte.addIngredient(new Coffee(15));
            toffeeLatte.addIngredient(new Milk(25));
            toffeeLatte.addIngredient(new Syrup());
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients!");
        }

        myCafe.addRecipe(toffeeLatte);

        myCafe.printMenu();

        try { 
            myCafe.removeRecipe("Espresso");
        } catch (RecipeNotFoundException e) {
            System.out.println("This recipe was not found");
        }

        myCafe.printMenu();        
    }   
}
