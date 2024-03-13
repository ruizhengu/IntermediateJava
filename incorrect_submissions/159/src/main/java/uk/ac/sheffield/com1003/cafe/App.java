package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import static uk.ac.sheffield.com1003.cafe.Recipe.Size.*;

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        cafe.addRecipe(new Recipe("Espresso",1.5, SMALL,2));
        Recipe DE = new Recipe("Double Espresso",2.2,REGULAR,2);
        try {
            DE.addIngredient(new Water(50));
            DE.addIngredient(new Coffee(15));
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        cafe.addRecipe(DE);
        cafe.addRecipe(new Recipe("large Soy Latte",2.5,LARGE,1));

        cafe.printMenu();
    }
}
