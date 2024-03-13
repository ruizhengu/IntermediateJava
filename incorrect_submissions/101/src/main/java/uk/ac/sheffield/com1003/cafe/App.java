package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {
        //creat a Cafe instance
        Cafe cafe = new Cafe();

        //creat espresso Recipe instance
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Coffee coffee = new Coffee(8, false);
        Water water = new Water(30);

        //add coffee and water to espresso
        try {
            espresso.addIngredient(coffee);
            espresso.addIngredient(water);
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        //creat doubleEspresso Recipe instance
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Coffee coffee2 = new Coffee(15);
        Water water2 = new Water(50);

        //add coffee and water to espresso
        try {
            doubleEspresso.addIngredient(coffee2);
            doubleEspresso.addIngredient(water2);
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        //creat largeSoyLatte instance
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 1);
        Milk milk = new Milk(20, Milk.Type.SOY);
        try {
            largeSoyLatte.addIngredient(milk);
        } catch (TooManyIngredientsException e) {
            throw new RuntimeException(e);
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }
}
