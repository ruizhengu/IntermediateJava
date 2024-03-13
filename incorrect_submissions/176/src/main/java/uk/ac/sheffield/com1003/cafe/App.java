package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] arg) {

        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso",1.5,Recipe.Size.SMALL,2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            System.out.println("Ingredients are more than number of ingredients");
        }
        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso",2.2,Recipe.Size.REGULAR,2);
        try {
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            System.out.println("Ingredients are more than number of ingredients");
        }
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5,Recipe.Size.LARGE,3);
        try {
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Water());
            largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("Ingredients are more than number of ingredients");
        }
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();

    }
}
