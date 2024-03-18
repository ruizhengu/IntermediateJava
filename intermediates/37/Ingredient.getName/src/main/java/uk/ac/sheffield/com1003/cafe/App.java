package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {

    public static void main (String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe myCafe = new Cafe("Appetito");     //Creating the Cafe object
        
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        espresso.addIngredient(new Coffee(8, false));
        espresso.addIngredient(new Water());    //Block for Espresso Recipe
        myCafe.addRecipe(espresso);

        Recipe doubEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        doubEspresso.addIngredient(new Coffee(15, false));
        doubEspresso.addIngredient(new Water(50));      //Block for Double Espresso Recipe
        //doubEspresso.addIngredient(new Syrup());
        myCafe.addRecipe(doubEspresso);

        Recipe lrgSoy = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        lrgSoy.addIngredient(new Water(20));
        lrgSoy.addIngredient(new Coffee(8, false));
        lrgSoy.addIngredient(new Milk(50, Type.SOY));       //Block for Soy Latte Recipe
        myCafe.addRecipe(lrgSoy);

        Recipe water = new Recipe("Just Water", 0.0, Size.LARGE, 1);
        water.addIngredient(new Water());
        myCafe.addRecipe(water);        //Block for Just Water Recipe

        myCafe.printMenu();     //Prints the Cafe's menu
        myCafe.removeRecipe("Large Soy Latte");
        myCafe.printMenu();     //Prints the Cafe's menu
        myCafe.addRecipe(lrgSoy);
        myCafe.printMenu();     //Prints the Cafe's menu
    }
}
