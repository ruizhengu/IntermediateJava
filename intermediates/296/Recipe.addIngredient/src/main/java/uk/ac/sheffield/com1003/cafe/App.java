package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {
        Cafe goatCafe = new Cafe();
        Recipe espresso = new Recipe("Espresso",1.50, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso",2.20, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.50, Recipe.Size.LARGE, 3);

        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        try {
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        try {
            largeSoyLatte.addIngredient(new Coffee(15, false));
            largeSoyLatte.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Milk(300, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        goatCafe.addRecipe(espresso);
        goatCafe.addRecipe(doubleEspresso);
        goatCafe.addRecipe(largeSoyLatte);

        goatCafe.printMenu();
    }
}
