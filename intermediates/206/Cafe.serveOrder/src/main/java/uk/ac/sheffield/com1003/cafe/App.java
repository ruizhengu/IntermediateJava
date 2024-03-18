package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException {
        Cafe newCafe = new Cafe("Cafe",10,1);

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee(8, false));
        espresso.addIngredient(new Water());
        newCafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15, false));
        doubleEspresso.addIngredient(new Water(50));
        newCafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE, 3);
        largeSoyLatte.addIngredient(new Coffee(60, false));
        largeSoyLatte.addIngredient(new Water(50));
        largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
        newCafe.addRecipe(largeSoyLatte);

        newCafe.printMenu();
    }
}
