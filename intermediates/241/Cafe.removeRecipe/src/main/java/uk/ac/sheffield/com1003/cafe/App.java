package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String [] args) throws TooManyIngredientsException{
        /**
         * Sets up new cafe with a very creative name
         * Adds three menu items with different sizes, prices and ingredients
         */
        Cafe Beanz = new Cafe("Beanz");

        Recipe Espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL,2);
        Espresso.addIngredient(new Water());
        Espresso.addIngredient(new Coffee());
        Beanz.addRecipe(Espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);
        doubleEspresso.addIngredient(new Water(50));
        doubleEspresso.addIngredient(new Coffee(15, false));
        Beanz.addRecipe(doubleEspresso);

        Recipe soyLatte = new Recipe("Soy Latte",2.5,Recipe.Size.LARGE,3);
        soyLatte.addIngredient(new Milk(25, Milk.Type.SOY));
        soyLatte.addIngredient(new Water (40));
        soyLatte.addIngredient(new Coffee(15,false));
        Beanz.addRecipe(soyLatte);
    }
}
