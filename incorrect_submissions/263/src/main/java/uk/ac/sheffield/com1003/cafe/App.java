package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

    public static void main(String[] args) {
        // Create Cafe instance.
        Cafe myCafe = new Cafe("Sheffield cafe");

        try {
            // Create a Recipe instance to make espresso.
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());


            // Create a Recipe instance to make Double Espresso
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));


            // Create a Recipe instance to make Large Soy Latte
            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Milk(300, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Water(100));

            //Add these Recipe instances to the Cafe object using the addRecipe() method.
            myCafe.addRecipe(espresso);
            myCafe.addRecipe(doubleEspresso);
            myCafe.addRecipe(largeSoyLatte);

        } catch (TooManyIngredientsException e) {
            System.err.println("Error;Too many ingredients in recipe !");
        }
        //call printMenu()
        myCafe.printMenu();

    }
}
