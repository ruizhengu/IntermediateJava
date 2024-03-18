package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args){
        //creating the cafe
        Cafe cafe = new Cafe();

        //adding espresso to the menu
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            cafe.addRecipe(espresso);
            System.out.println(espresso.getName() + " added to the menu");
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many Ingredients");
        }

        //adding doubleEspresso to the menu
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);
            System.out.println(doubleEspresso.getName() + " added to the menu");
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many Ingredients");
        }


        //adding largeSoyLatte to the menu
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.REGULAR, 2);
        try {
            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
            cafe.addRecipe(largeSoyLatte);
            System.out.println(largeSoyLatte.getName() + " added to the menu");
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many Ingredients");
        }

        cafe.printMenu();


    }
}
