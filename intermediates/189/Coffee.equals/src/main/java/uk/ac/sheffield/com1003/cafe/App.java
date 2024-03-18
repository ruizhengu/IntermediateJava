package uk.ac.sheffield.com1003.cafe;

/* Importing the exception and ingredient subclasses that are used in this file */
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {
        /* New cafe created, with an espresso recipe created which has price £1.50 and is made of 2 ingredients */
        Cafe Cafe = new Cafe();
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }
        Cafe.addRecipe(espresso);
        /* Same code is used for creating a double espresso */
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }
        Cafe.addRecipe(doubleEspresso);
        /* Finally the large soy latte recipe is created which uses a different type of milk */
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        try {
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Milk(75, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }
        Cafe.addRecipe(largeSoyLatte);
        /* Menu printed out using the Cafe class' print method */
        Cafe.printMenu();
    }

}
