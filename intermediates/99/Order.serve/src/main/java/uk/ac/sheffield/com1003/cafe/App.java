package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args){
        Cafe myCafe = new Cafe("Paula's cafe");
        Recipe espresso = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {

        }
        myCafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Recipe.Size.REGULAR, 2);

        try {
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {

        }
        myCafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.50, Recipe.Size.LARGE, 1);
        try {
            largeSoyLatte.addIngredient(new Milk(50, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {

        }
        myCafe.addRecipe(largeSoyLatte);

        myCafe.printMenu();
    }
}
