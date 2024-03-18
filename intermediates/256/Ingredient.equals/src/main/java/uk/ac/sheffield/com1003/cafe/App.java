package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String [] args) throws TooManyIngredientsException {
        // creates new cafe object
        Cafe newCafe = new Cafe ("New Cafe", 3, 10);

        // creates menu items
        Recipe espresso = new Recipe ("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe ("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe ("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);

        // sets ingredients
        espresso.addIngredient(new Coffee(8, false));
        espresso.addIngredient(new Water());

        doubleEspresso.addIngredient(new Coffee(15, false));
        doubleEspresso.addIngredient(new Water(50));

        largeSoyLatte.addIngredient(new Coffee(15, false));
        largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));

        // adds items to cafe menu
        newCafe.addRecipe(espresso);
        newCafe.addRecipe(doubleEspresso);
        newCafe.addRecipe(largeSoyLatte);

        newCafe.printMenu();

    }
}
