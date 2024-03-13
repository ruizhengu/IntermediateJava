package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;

public class App {
    public static void main(String[] args) throws Exception {
        // create a new cafe
        Cafe myCafe = new Cafe("Central Perk");


        // create some ingredients
        Ingredient coffee = new Coffee();
        Ingredient water = new Water();


        // create some recipes
        Recipe espressoRecipe = new Recipe("Espresso", 1.5, Recipe.Size.SMALL,2);
        Recipe doubleEspressoRecipe =  new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR,2);
        Recipe latteRecipe =  new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE,3);
        Recipe latteRecipe2 =  new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE,3);

        // add recipes to the cafe's menu
        myCafe.addRecipe(espressoRecipe);
        myCafe.addRecipe(doubleEspressoRecipe);
        myCafe.addRecipe(latteRecipe);
        myCafe.addRecipe(latteRecipe2);

        // add ingredients to the recipes
        espressoRecipe.addIngredient(new Coffee());
        espressoRecipe.addIngredient(new Water());

        doubleEspressoRecipe.addIngredient(new Coffee(15));
        doubleEspressoRecipe.addIngredient(new Water(20));

        latteRecipe.addIngredient(new Milk(70,Milk.Type.SOY));

        latteRecipe2.addIngredient(new Milk(70,Milk.Type.SOY));

       
        myCafe.printMenu();

        myCafe.placeOrder("Espresso", "Talhah", 9);

        myCafe.removeRecipe("Espresso");

        myCafe.printPendingOrders();

        System.out.println("SAME? : " + latteRecipe.equals(latteRecipe2));

        myCafe.printMenu();

    }

}
