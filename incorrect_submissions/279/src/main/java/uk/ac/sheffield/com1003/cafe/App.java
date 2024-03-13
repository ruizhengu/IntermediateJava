package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] arg) {
        try {
            //Recipe ========================================
            Recipe latte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            Cafe cafe = new Cafe("Central Perk", 8, 1);


            //ADD RECIPE======================================
            cafe.addRecipe(latte);
            cafe.addRecipe(doubleEspresso);
            cafe.addRecipe(espresso);
            System.out.println("The recipes are added to the menu");

            //ADD INGREDIENT ======================================
            latte.addIngredient(new Coffee());
            latte.addIngredient(new Milk(10, Milk.Type.SOY));
            doubleEspresso.addIngredient(new Water(50));
            doubleEspresso.addIngredient(new Coffee(15));
            espresso.addIngredient(new Coffee(8));
            espresso.addIngredient(new Water());
            System.out.println("The recipes are ready");



            //MENU ====================================
            cafe.printMenu();
            cafe.placeOrder("Espresso", "nd", 4);

        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        } catch (CafeOutOfCapacityException e) {
            throw new RuntimeException(e);
        } catch (RecipeNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
