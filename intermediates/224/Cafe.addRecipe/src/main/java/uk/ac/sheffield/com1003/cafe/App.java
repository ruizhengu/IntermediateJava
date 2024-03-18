package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import javax.management.openmbean.InvalidOpenTypeException;

public class App {
    public static void main(String[] args) {

        //code for creating Espresso recipe instance
        Recipe espresso = 
            new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients added to the recipe.");
        }

        //code for creating Double Espresso recipe instance
        Recipe doubleEspresso = 
            new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients added to the recipe.");
        }

        //code for creating Large Soy Latte Recipe instance
        Recipe largeSoyLatte = 
            new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        try {
            largeSoyLatte.addIngredient(new Milk(200, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Water());
            largeSoyLatte.addIngredient(new Coffee());
        } catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients added to the recipe.");
        }

        //calling cafe instructor to create new cafe instance with name My Cafe
        Cafe cafe = new Cafe("My Cafe");

        // adding the recipes to the cafe
        cafe.addRecipe(largeSoyLatte);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(espresso);

        //printing the cafe menu
        cafe.printMenu();
    }
}
