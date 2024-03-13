package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe myCafe = new Cafe("Usmaan's Cafe");
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        myCafe.addRecipe(espresso);

        Recipe latte = new Recipe("latte", 2.2);
        latte.addIngredient(new Coffee(15, false));
        latte.addIngredient(new Water(50));
        myCafe.addRecipe(latte);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        latte.addIngredient(new Milk(100, Milk.Type.SOY));
        latte.addIngredient(new Water());
        latte.addIngredient(new Coffee(20, true));
        myCafe.addRecipe(largeSoyLatte);

        myCafe.placeOrder("Large Soy Latte", "SK", 200.00);
        myCafe.printPendingOrders();
    }
}
