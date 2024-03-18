package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Tranquility Base Cafe & Casino", 3, 100);
        Recipe espresso = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch(TooManyIngredientsException ex) {
            System.out.println("Espresso has too many ingredients!");
        }

        myCafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException ex) {
            System.out.println("Double Espresso has too man ingredients");
        }

        myCafe.addRecipe(doubleEspresso);

        Recipe soyLatte = new Recipe("Soy Latte", 2.50, Recipe.Size.LARGE, 5);
        try {
            // Start with a double espresso
            soyLatte.addIngredient(new Coffee(15));
            soyLatte.addIngredient(new Water(50));

            soyLatte.addIngredient(new Milk(30, Milk.Type.SOY));
            soyLatte.addIngredient(new VanillaExtract(3)); // Half a teaspoon of vanilla extract
            soyLatte.addIngredient(new Syrup("Maple")); // 1 teaspoon of maple syrup
        } catch (TooManyIngredientsException ex) {
            System.out.println("Double Espresso has too man ingredients");
        }

        myCafe.addRecipe(soyLatte);

        myCafe.printMenu();
    }
}
