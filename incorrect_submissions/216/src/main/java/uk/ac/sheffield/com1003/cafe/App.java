package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

//Creating a main class app to input the recipe and function parameters correctly.

public class App {
    //the main method creates a recipe object that each represent a coffee recipe.
    public static void main(String[] args) throws TooManyIngredientsException {
        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee(8));
        espresso.addIngredient(new Water(30));
        cafe.addRecipe(espresso);


        Recipe doubleEspresso = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);
        doubleEspresso.addIngredient(new Coffee (15));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);

        Recipe soyLatte =  new Recipe ("Soy Latte",2.5, Recipe.Size.LARGE,3);
        soyLatte.addIngredient(new Coffee(20));
        soyLatte.addIngredient(new Milk(100, Milk.Type.WHOLE ));
        soyLatte.addIngredient(new Milk(50, Milk.Type.SOY));
        cafe.addRecipe(soyLatte);

        cafe.printMenu();










    }
}





