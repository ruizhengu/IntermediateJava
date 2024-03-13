package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import java.lang.ProcessBuilder.Redirect.Type;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;



public class App {





    public static void main(String[] args){
        Cafe cafe = new Cafe();

        //ESPRESSO
        Recipe newRecipe = new Recipe("Espresso",1.5,Size.SMALL,2);
        try {
            newRecipe.addIngredient( new Coffee());
        } catch (TooManyIngredientsException e) {
            System.out.println("too many ingredients exception caught");
        }
        cafe.addRecipe(newRecipe);

        //DOUBLE ESPRESSO
        newRecipe = new Recipe("Double Espresso",2.2,Size.REGULAR,2);
        try {
            newRecipe.addIngredient(new Coffee(15));
            newRecipe.addIngredient(new Water(15));

        } catch (TooManyIngredientsException e) {
            System.out.println("too many ingredients exception caught");
        }
        cafe.addRecipe(newRecipe);

        //LARGE SOY LATTE
        newRecipe = new Recipe("Large Soy Latte",2.5,Size.LARGE,2);
        try {
            newRecipe.addIngredient(new Coffee());
            newRecipe.addIngredient(new Milk(15, Milk.Type.SOY));

        } catch (TooManyIngredientsException e) {
            System.out.println("too many ingredients exception caught");
        }
        cafe.addRecipe(newRecipe);
    }
}
