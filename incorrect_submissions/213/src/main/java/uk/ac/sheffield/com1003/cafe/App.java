package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args)
    {
        //Creates a new Cafe class called drinks
        Cafe drinks = new Cafe();

        //Creates 3 recipes to be added later to the drinks object
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);

        try 
        {
            //attempts to add ingredients to the recipe objects
            espresso.addIngredient(new Coffee(8, false));
            espresso.addIngredient(new Water(30));
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Coffee(20, false));
            largeSoyLatte.addIngredient(new Milk(300, Type.SOY));
            largeSoyLatte.addIngredient(new Water(200));
        }
        catch (TooManyIngredientsException ex)
        {
            //only happens if the amount of ingredients being added exceeds what is allowed
            System.out.println("Too many ingredients added to recipe");
        }

        //adds the recipes to the drinks objects
        drinks.addRecipe(largeSoyLatte);
        drinks.addRecipe(espresso);
        drinks.addRecipe(doubleEspresso);

        //displays the menu
        drinks.printMenu();
    }
}
