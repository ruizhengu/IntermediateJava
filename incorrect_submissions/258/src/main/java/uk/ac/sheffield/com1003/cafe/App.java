package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

import static uk.ac.sheffield.com1003.cafe.ingredients.Unit.GR;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException,
            RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe("Central Perk");

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee(8,false));
        espresso.addIngredient(new Water(30));
        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15, false));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 1);
        largeSoyLatte.addIngredient(new Milk(Milk.Type.SOY));
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
//        cafe.placeOrder("Espresso", "JIHYE", 1.5);
//        cafe.printPendingOrders();
    }
}
