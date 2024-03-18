package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Unit;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

public class App {
    public static void main (String[] args) throws TooManyIngredientsException, CafeOutOfCapacityException, RecipeNotFoundException {
        //create cafe
        Cafe brewinc = new Cafe("brewinc", 3, 100);

        //create recipes
        Recipe Espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe DoubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe LargeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        Recipe SoyLatte = new Recipe("Soy Latte", 2.5, Recipe.Size.LARGE, 3);

        //create ingredients
        Coffee defaultCoffee = new Coffee();
        Water defaultWater = new Water();
        Coffee dblEspCoffee = new Coffee(15);
        Water dblEspWater = new Water(50);
        Milk soyMilk = new Milk(100, Milk.Type.SOY);

        //add ingredients to recipes
        Espresso.addIngredient(defaultCoffee);
        Espresso.addIngredient(defaultWater);
        DoubleEspresso.addIngredient(dblEspCoffee);
        DoubleEspresso.addIngredient(dblEspWater);
        LargeSoyLatte.addIngredient(dblEspCoffee);
        LargeSoyLatte.addIngredient(dblEspWater);
        LargeSoyLatte.addIngredient(soyMilk);
        SoyLatte.addIngredient(dblEspCoffee);
        SoyLatte.addIngredient(dblEspWater);
        SoyLatte.addIngredient(soyMilk);

        //add recipes to cafe
        brewinc.addRecipe(Espresso);
        brewinc.addRecipe(DoubleEspresso);
        brewinc.addRecipe(LargeSoyLatte);
        brewinc.addRecipe(SoyLatte);

        //print menu
        brewinc.printMenu();
    }
}