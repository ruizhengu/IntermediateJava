package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {

        Cafe myCafe = new Cafe();
        myCafe.addRecipe(new Recipe("Espresso",1.5,Recipe.Size.SMALL,2));
        myCafe.addRecipe(new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2));
        myCafe.addRecipe(new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE,3));

        try {
            myCafe.getMenu()[0].addIngredient(new Coffee());
            myCafe.getMenu()[0].addIngredient(new Water());
            myCafe.getMenu()[1].addIngredient(new Coffee(15)); //Override amount
            myCafe.getMenu()[1].addIngredient(new Water(50)); //Override amount
            myCafe.getMenu()[2].addIngredient(new Coffee(20));
            myCafe.getMenu()[2].addIngredient(new Water(20));
            myCafe.getMenu()[2].addIngredient(new Milk(50, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        myCafe.printMenu();

    }
}
