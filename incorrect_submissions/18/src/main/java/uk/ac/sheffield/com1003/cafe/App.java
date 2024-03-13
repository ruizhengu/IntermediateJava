package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
        //Creation of a myCafe object
         Cafe myCafe = new Cafe();

         //Recipe Creation for Espresso
         Recipe espresso = new Recipe("Espresso",1.50, Recipe.Size.SMALL,2);
         espresso.addIngredient(new Water());
         espresso.addIngredient(new Coffee());

         //Recipe Creation for Double Espresso
         Recipe doubleEspresso = new Recipe("Double Espresso",2.20, Recipe.Size.REGULAR,2);
         doubleEspresso.addIngredient(new Water(50));
         doubleEspresso.addIngredient(new Coffee(15));

         Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.50, Recipe.Size.LARGE,3);
         largeSoyLatte.addIngredient(new Milk(3000, Milk.Type.SOY));
         largeSoyLatte.addIngredient(new Water(7500));
         largeSoyLatte.addIngredient(new Coffee(3000));

         //Adding recipes to myCafe
        myCafe.addRecipe(espresso);
        myCafe.addRecipe(doubleEspresso);
        myCafe.addRecipe(largeSoyLatte);

    }
}
