package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

public class App {
    public static void main(String[]args) throws TooManyIngredientsException, RecipeNotFoundException {
        //Create a Café
        Cafe Cafe1 = new Cafe("LZZ Cafe",3,100);
        //Add the recipe "Espresso"
        Recipe espresso = new Recipe("Espresso", 1.5,Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        Cafe1.addRecipe(espresso);

        //Add the recipe "Double Espresso"
        Recipe dEspresso = new Recipe("Double Espresso",2.2, Size.REGULAR,2);
        dEspresso.addIngredient(new Coffee(15,true));
        dEspresso.addIngredient(new Water(50));
        Cafe1.addRecipe(dEspresso);

        //Add the recipe "Large Soy Latte"
        Recipe LSoyLatte = new Recipe("Large Soy Latte", 2.5,Size.LARGE,3);
        LSoyLatte.addIngredient(new Coffee());
        LSoyLatte.addIngredient(new Water());
        LSoyLatte.addIngredient(new Milk(50,Type.SOY));
        Cafe1.addRecipe(LSoyLatte);

        Cafe1.printMenu();
    }
}

