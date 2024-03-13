package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args )throws TooManyIngredientsException{
        Cafe cafe = new Cafe("Cafe", 10, 100);

        // Creating an espresso recipe, adding ingredients then adding to cafe
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);

        // Creating a doubleEspresso recipe, adding ingredients then adding to cafe
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);
        
        // Creating a largeSoyLatte recipe, adding ingredients then adding to cafe
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
        largeSoyLatte.addIngredient(new Coffee(30));
        largeSoyLatte.addIngredient(new Water(30));
        cafe.addRecipe(largeSoyLatte);

        //Printing cafe menu
        cafe.printMenu();
    }
}
