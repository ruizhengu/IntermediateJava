package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {

    /**
     * 
     * main method to create Recipe instances and add them to a Cafe menu.
     * there are try an catch exceptions to catch if there are too many ingredients
     * recipes are added to cafe
     * calls print menu method at
     * 
     * @param args
     */
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Recipe Espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        try {
            Espresso.addIngredient(new Coffee());
            Espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException exc) {
            System.out.println("Throws too many ingredients");
        }

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException exc) {
            System.out.println("Throws too many ingredients");
        }
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        try {
            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Milk(100, Type.SOY));
        } catch (TooManyIngredientsException exc) {
            System.out.println("Throws too many ingredients");
        }

        cafe.addRecipe(Espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }

}
