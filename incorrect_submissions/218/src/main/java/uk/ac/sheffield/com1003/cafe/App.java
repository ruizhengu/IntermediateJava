package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;


/**
 * The main method creates a Cafe object and then adds three different recipes to the menu of the Cafe.
 * It throws and catches the TooManyIngredientsException exception when trying to add more ingredients to a recipe than allowed. 
 * Finally, it prints out the menu of the Cafe object.
 * 
 * @param args command line arguments (not used)
 */

public class App {

    public static void main(String[] args) {

        Cafe shop = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        }
        catch (TooManyIngredientsException e) {
            System.out.println("There's too many ingredients");
        }


        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        try { 
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        }
        catch (TooManyIngredientsException e) {
            System.out.println("There's too many ingredients");
        }


        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        try {
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Milk(8, Type.SOY));
        }
        catch (TooManyIngredientsException e) {
            System.out.println("There's too many ingredients");
        }

        shop.addRecipe(espresso);
        shop.addRecipe(doubleEspresso);
        shop.addRecipe(largeSoyLatte);
            
        shop.printMenu();

    }
}