package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
        //task 1
        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);

        Ingredient coffee = new Coffee();
        Ingredient coffeeDoubleEspresso = new Coffee(15);
        Ingredient water = new Water();
        Ingredient waterDoubleEspresso = new Water(50);
        Ingredient soyMilk = new Milk(100, Milk.Type.SOY);

        try {
            //Espresso is Coffee: 8g, Water: 30ml
            espresso.addIngredient(coffee);
            espresso.addIngredient(water);
            //Double Espresso is Coffee 15g, Water 50ml
            doubleEspresso.addIngredient(coffeeDoubleEspresso);
            doubleEspresso.addIngredient(waterDoubleEspresso);
            //Large Soy Latte is Coffee: 8g, Milk 100ml type SOY
            largeSoyLatte.addIngredient(coffee);
            largeSoyLatte.addIngredient(soyMilk);
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        //task 2
        cafe.printMenu();
    }
}
