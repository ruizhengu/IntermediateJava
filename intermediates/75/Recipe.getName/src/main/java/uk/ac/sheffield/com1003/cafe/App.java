package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

/**
 * Class in which the main program is ran.
 */
public class App {
    public static void main(String[] args) {
        // creates new cafe instance
        Cafe cafe = new Cafe();

        // creates new recipe instances, adds ingredients to the recipes
        // and handles the TooManyIngredientsException
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));

            largeSoyLatte.addIngredient(new Milk(250, Type.SOY));
            largeSoyLatte.addIngredient(new Coffee(15, false));
        } catch (TooManyIngredientsException e) {
            System.out.println(e + " Cannot add more ingredients than the number of ingredients specified");
        }

        if (espresso.isReady()) {
            cafe.addRecipe(espresso);
        }
        if (doubleEspresso.isReady()) {
            cafe.addRecipe(doubleEspresso);
        }
        if (largeSoyLatte.isReady()) {
            cafe.addRecipe(largeSoyLatte);
        }
        
        cafe.printMenu();
    }
  
}
