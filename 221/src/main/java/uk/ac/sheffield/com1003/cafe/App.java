package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {
    public static void main(String[] args) {
        // Task 1
        Cafe myCafe = new Cafe ();
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL,2);
        Recipe doubleEspresso = new Recipe( "Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe( "Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Milk(400, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added to recipe");
        }
        myCafe.addRecipe(espresso);
        myCafe.addRecipe(doubleEspresso);
        myCafe.addRecipe(largeSoyLatte);

        // Task 2
        myCafe.printMenu();

    }
}
