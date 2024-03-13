package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args){

        Cafe cafe = new Cafe();

        /**
         * Create recipe with it's ingredients, use try-catch to handle exception
         */
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        try {
            espresso.addIngredient(new Water());
            espresso.addIngredient(new Coffee());
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Water(50));
            doubleEspresso.addIngredient(new Coffee(15));
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        try {
            largeSoyLatte.addIngredient(new Milk(50, Type.SOY));
            largeSoyLatte.addIngredient(new Water(25));
            largeSoyLatte.addIngredient(new Coffee(100));
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        /**
         * Add recipe to the cafe if the recipe is ready
         */
        if (espresso.isReady()){
            cafe.addRecipe(espresso);
        }
        if (doubleEspresso.isReady()){
            cafe.addRecipe(doubleEspresso);
        }
        if (largeSoyLatte.isReady()){
            cafe.addRecipe(largeSoyLatte);
        }

        /**
         * Print the menu
         */
        cafe.printMenu();
    }
}
