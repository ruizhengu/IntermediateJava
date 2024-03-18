package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        try {
            Recipe espresso = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            cafe.addRecipe(espresso);
        }catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added to recipe.");
        }
        try{
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Recipe.Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);
        }catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added to recipe.");
        }

        try {
            Recipe soyLatte = new Recipe("Large Soy Latte", 2.50, Recipe.Size.LARGE, 1);
            soyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
            cafe.addRecipe(soyLatte);
        }catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added to recipe.");
        }

        cafe.printMenu();
    }
}
