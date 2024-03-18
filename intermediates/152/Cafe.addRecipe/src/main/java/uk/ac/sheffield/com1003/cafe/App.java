package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {

    public static void main(String[] args) throws TooManyIngredientsException, CafeOutOfCapacityException, RecipeNotFoundException {
        Cafe c1 = new Cafe();
        Recipe r1 = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe r2 = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe r3 = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        r1.addIngredient(new Water());
        r1.addIngredient(new Coffee());
        r2.addIngredient(new Water(50));
        r2.addIngredient(new Coffee(15));
        r3.addIngredient(new Water(60));
        r3.addIngredient(new Coffee(10));
        r3.addIngredient(new Milk(15, Milk.Type.SOY));
        c1.addRecipe(r1);
        c1.addRecipe(r2);
        c1.addRecipe(r3);
    } 
}
