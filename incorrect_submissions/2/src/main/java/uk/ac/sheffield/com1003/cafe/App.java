package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    private Recipe espresso;
    private Recipe doubleEspresso;
    private Recipe largeSoyLatte;
    public static void main(String[] args) throws RecipeNotFoundException, CafeOutOfCapacityException {
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2,
                Recipe.Size.REGULAR, 2);

        //contains water and milk
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5,
                Recipe.Size.LARGE, 3);

        //creates a new Cafe instance
        Cafe cafe = new Cafe();

        //adds the recipes to the Cafe
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);


        //implementing the menu
        cafe.printMenu();
    }
}
