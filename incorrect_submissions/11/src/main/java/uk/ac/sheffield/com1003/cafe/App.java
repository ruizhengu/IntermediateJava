package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;

public class App {


    public static void main(String[] args) throws TooManyIngredientsException {
        Cafe cafe = new Cafe("Central Perk", 10, 100);


        // create Espresso recipe
        Coffee coffee = new Coffee(8, false);
        Water water = new Water(30);
        Recipe espressoRecipe = new Recipe("Espresso", 1.5, Recipe.Size.SMALL,2);
        try {
            espressoRecipe.addIngredient(coffee);
            espressoRecipe.addIngredient(water);
            cafe.addRecipe(espressoRecipe);
        }
        catch (TooManyIngredientsException e){
            System.err.println("Error too many ingredients: " + e.getMessage());
            throw e;
        }

        // create Double Espresso recipe
        Coffee doubleEspressoCoffee = new Coffee(15, false);
        Water doubleEspressoWater = new Water(50);
        Recipe doubleEspressoRecipe = new Recipe("Double Espresso", 2,
                Recipe.Size.REGULAR, 2);
        try {
            doubleEspressoRecipe.addIngredient(doubleEspressoCoffee);
            doubleEspressoRecipe.addIngredient(doubleEspressoWater);
            cafe.addRecipe(doubleEspressoRecipe);
        }
        catch (TooManyIngredientsException e){
            System.err.println("Error too many ingredients: " + e.getMessage());
            throw e;
        }

        // create Large Soy Latte recipe
        Milk soyMilk = new Milk(90, Milk.Type.SOY);
        Coffee latteCoffee = new Coffee(12, false);
        Water latteWater = new Water(50);
        Recipe soyLatteRecipe = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        try {
            soyLatteRecipe.addIngredient(soyMilk);
            soyLatteRecipe.addIngredient(latteWater);
            soyLatteRecipe.addIngredient(latteCoffee);
            cafe.addRecipe(soyLatteRecipe);
        }
        catch  (TooManyIngredientsException e){
            System.err.println("Error too many ingredients: " + e.getMessage());
            throw e;
        }

        // print all recipes
        cafe.printMenu();
    }

}
