package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Recipe espresso = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);

        try {
            espresso.addIngredient(new Coffee(8, false));
            espresso.addIngredient(new Water(30));

            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
            doubleEspresso.addIngredient(new Syrup("A"));

            largeSoyLatte.addIngredient(new Milk(10, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Coffee(8, false));
        } catch(TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);
        cafe.printMenu();
    }
}