package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;

public class App {
    public static void main (String[] args) {
        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch(TooManyIngredientsException e){
            System.out.println("Too many ingredients");
        }
        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch(TooManyIngredientsException e){
            System.out.println("Too many ingredients");
        }
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        try {
            largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Coffee());
        } catch(TooManyIngredientsException e){
            System.out.println("Too many ingredients");
        }
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }
}