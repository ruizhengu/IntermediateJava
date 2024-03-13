package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException,
            RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe("S Cafe");

        Recipe Espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
            Espresso.addIngredient(new Coffee(8,false));
            Espresso.addIngredient(new Water());

        Recipe DoubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 3);
            DoubleEspresso.addIngredient(new Coffee(15, false));
            DoubleEspresso.addIngredient(new Water(50));

        Recipe LargeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
            LargeSoyLatte.addIngredient(new Milk(200, Milk.Type.SOY));
            LargeSoyLatte.addIngredient(new Coffee(15, true));
            LargeSoyLatte.addIngredient(new Syrup("Vanilla", 20));


        Recipe Water = new Recipe("Just Water", 1, Size.LARGE, 1);
            Water.addIngredient(new Water(500));


        cafe.addRecipe(Espresso);
        cafe.addRecipe(DoubleEspresso);
        cafe.addRecipe(LargeSoyLatte);
        cafe.addRecipe(Water);


        cafe.printMenu();


    }
}
