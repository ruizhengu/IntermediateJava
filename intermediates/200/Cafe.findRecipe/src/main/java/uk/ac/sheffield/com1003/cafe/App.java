package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;


public class App {
    public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
       Cafe myCafe = new Cafe("myCafe",3,100);

       Recipe Esspresso = new Recipe("Esspresso", 1.5, Recipe.Size.SMALL, 2);
       Esspresso.addIngredient(new Water());
       Esspresso.addIngredient(new Coffee());
       myCafe.addRecipe(Esspresso);

        Recipe doubleEsspresso = new Recipe("Double Esspresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEsspresso.addIngredient(new Water(50));
        doubleEsspresso.addIngredient(new Coffee(15,false));
        myCafe.addRecipe(doubleEsspresso);


        //I don't know how to make a soy latte apologies
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        largeSoyLatte.addIngredient(new Water(50));
        largeSoyLatte.addIngredient(new Coffee(15,false));
        largeSoyLatte.addIngredient(new Milk(30, Milk.Type.SOY));
        myCafe.addRecipe(largeSoyLatte);




    }
}
