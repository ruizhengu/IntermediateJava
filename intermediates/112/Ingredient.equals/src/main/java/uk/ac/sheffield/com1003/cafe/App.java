package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

/**
 * App.java  12/03/2023
 * 
 * Modified by Lucas Madle
 */
public class App {
    public static void main(String[] args) {
        Cafe cafe = InitialiseCafe();
        cafe.printMenu();
    }

    private static Cafe InitialiseCafe() {
        Recipe espresso = new Recipe("Espresso", 1.50, Size.SMALL, 2);
        Recipe dEspresso = new Recipe("Double Espresso", 2.20, Size.REGULAR, 2);        
        Recipe soyLatte = new Recipe("Large soy Latte", 2.50, Size.LARGE, 3);

        Cafe cafe = new Cafe();
        cafe.addRecipe(espresso);
        cafe.addRecipe(dEspresso);
        cafe.addRecipe(soyLatte);
        try {
            espresso.addIngredient(new Water());
            espresso.addIngredient(new Coffee());

            dEspresso.addIngredient(new Water(15));
            dEspresso.addIngredient(new Coffee(50));

            
            soyLatte.addIngredient(new Coffee());
            soyLatte.addIngredient(new Milk(250, Type.SOY));
            soyLatte.addIngredient(new Syrup());

            return cafe;
        }
        catch (TooManyIngredientsException e) {
            System.err.println(e.toString() + ": some recipes may be lost.");
            return cafe;
        }
    }
}
