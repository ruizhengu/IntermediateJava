package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {
    public static void main(String[] args) {

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Task 1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Cafe cafferia = new Cafe(); //cafe instance - called it cafferia because it's in my language and didn't know what else to call it
        //Making and adding
        //... first recipe - Espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Coffee espressoCoffee = new Coffee(8);
        addIngredientCatch(espresso, espressoCoffee);
        Water espressoWater = new Water(30);
        addIngredientCatch(espresso, espressoWater);
        cafferia.addRecipe(espresso);

        //... second recipe - Double Espresso
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Coffee doubleEspressoCoffee = new Coffee(15);
        addIngredientCatch(doubleEspresso, doubleEspressoCoffee);
        Water doubleEspressoWater = new Water(50);
        addIngredientCatch(doubleEspresso, doubleEspressoWater);
        cafferia.addRecipe(doubleEspresso);

        //... third recipe - Large Soy Latte
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        Milk soyForLargeLatte = new Milk(35, Milk.Type.SOY);
        addIngredientCatch(largeSoyLatte, soyForLargeLatte);
        Coffee coffeeForLargeLatte = new Coffee(20);
        addIngredientCatch(largeSoyLatte, coffeeForLargeLatte);
        cafferia.addRecipe(largeSoyLatte);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        cafferia.printMenu();
    }

    private static void addIngredientCatch(Recipe recipe, Ingredient ingredient) {
        try {
            recipe.addIngredient(ingredient);
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }
    }


}
