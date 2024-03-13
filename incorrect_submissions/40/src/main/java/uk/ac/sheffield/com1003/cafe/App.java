package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    private static final Cafe cafe = new Cafe();
    public static void main(String[] args) {

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);

        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Coffee(25));
            largeSoyLatte.addIngredient(new Milk(40, Milk.Type.SOY));
        }
        catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }
}
