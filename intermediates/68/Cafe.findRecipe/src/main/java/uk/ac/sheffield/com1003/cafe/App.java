package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

    public static void main(String[] args){

        Cafe cafe = new Cafe();

        //recipe instantiation: (NEEDED IN APP.MAIN)
        Recipe espressoRecipe = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspressoRecipe = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatteRecipe = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);

        //making recipes: (NEEDED IN APP.MAIN)
        try{
            espressoRecipe.addIngredient(new Coffee());
            espressoRecipe.addIngredient(new Water());

            doubleEspressoRecipe.addIngredient(new Coffee(15));
            doubleEspressoRecipe.addIngredient(new Water(50));

            largeSoyLatteRecipe.addIngredient(new Coffee(30));
            largeSoyLatteRecipe.addIngredient(new Milk(120, Milk.Type.SOY));
        }
        catch(TooManyIngredientsException e){
            System.out.println("Checked exception in Recipe.addIngredient");
        }

        //add recipes to menu: (NEEDED IN APP.MAIN)
        cafe.addRecipe(espressoRecipe);
        cafe.addRecipe(doubleEspressoRecipe);
        cafe.addRecipe(largeSoyLatteRecipe);

        //print menu: (NEEDED IN APP.MAIN)
        cafe.printMenu();
    }
}
