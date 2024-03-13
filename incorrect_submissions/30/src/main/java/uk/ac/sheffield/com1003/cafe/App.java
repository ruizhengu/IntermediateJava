package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;

public class App {
    public static void main(String[] args) throws RecipeNotFoundException, CafeOutOfCapacityException{

        //instantiating cafe
        Cafe myCafe = new Cafe("My Cafe", 10,100);

        //instatiating recipes
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, 
          Recipe.Size.REGULAR, 2);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, 
          Recipe.Size.LARGE,2);

        //adding ingredients to instantiated recipes
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("Exception: Too many Ingredients");
        }

        //adding recipes to Cafe
        myCafe.addRecipe(espresso);
        myCafe.addRecipe(doubleEspresso);
        myCafe.addRecipe(largeSoyLatte);
        
        myCafe.printMenu();

    }

}
