package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException,
            CafeOutOfCapacityException {
        Cafe c = new Cafe();
        Recipe r1 = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe r2 = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe r3 = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        try{
            r1.addIngredient(new Coffee(8));
            r1.addIngredient(new Water(30));
            r2.addIngredient(new Coffee(15));
            r2.addIngredient(new Water(50));
            r3.addIngredient(new Coffee(7));
            r3.addIngredient(new Milk(20, Milk.Type.WHOLE));
            r3.addIngredient(new Syrup(5, "Caramel"));
        }
        catch(TooManyIngredientsException e){
            System.out.println("Number of ingredients exceeded.");
        }

        c.addRecipe(r1);
        c.addRecipe(r2);
        c.addRecipe(r3);
        c.printMenu();

    }
}
