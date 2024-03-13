package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException {
        // Initialize cafe instance with default parameters
        Cafe myCafe = new Cafe();

        // Create the given espresso recipe
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        // And add it to the cafe
        myCafe.addRecipe(espresso);
        // Do the same for a double espresso and large soy latte
      
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));
        myCafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        // Not specified what the ingredients of a large soy latte are, I assume it involves coffee so I gave
        // it the default amount of coffee and 100ml of soy milk
        largeSoyLatte.addIngredient(new Coffee());
        largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
        myCafe.addRecipe(largeSoyLatte);
        myCafe.printMenu();
    }
}
