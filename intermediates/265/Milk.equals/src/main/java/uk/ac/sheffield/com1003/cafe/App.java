package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args){
        Cafe cafe = new Cafe("Central Perk", 10, 100);

        //Creating the three drink recipes
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        }
        catch (TooManyIngredientsException a){
            System.out.println("Too many ingredients");
        }

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try{
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
        }
        catch (TooManyIngredientsException a){
            System.out.println("Too many ingredients");
        }

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        try {
            largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Coffee(15, false));
            largeSoyLatte.addIngredient(new Water());
        }
        catch (TooManyIngredientsException a){
            System.out.println("Too many ingredients");
        }

        //Adding the drink recipes to the cafe
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }
}
