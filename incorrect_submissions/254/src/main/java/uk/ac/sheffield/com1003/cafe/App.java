package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) {

        /* instantiate the main cafe object */
        Cafe cafe = new Cafe("Cafe", 3, 3);

        /* add espresso recipe */
        Ingredient[] espressoIngredients = new Ingredient[] {new Coffee(), new Water()};
        Recipe espresso = createNewRecipe("espresso", 1.5, Size.SMALL, espressoIngredients);
        cafe.addRecipe(espresso);

        /* add double espresso recipe */
        Ingredient[] doubleEspressoIngredients = new Ingredient[] {new Coffee(15), new Water(50)};
        Recipe doubleEspresso = createNewRecipe("double espresso", 2.2, Size.REGULAR, doubleEspressoIngredients);
        cafe.addRecipe(doubleEspresso);

        /* add large soy latte recipe */
        Ingredient[] largeSoyLatteIngredients = new Ingredient[] {new Coffee(8), new Milk(200, Type.SOY)};
        Recipe largeSoyLatte = createNewRecipe("large soy latte", 2.5, Size.LARGE, largeSoyLatteIngredients);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }

    /** 
     * method to create a recipe and add the given ingredients
     */
    public static Recipe createNewRecipe(String name, double price, Size size, Ingredient[] ingredients) {
        Recipe newRecipe = new Recipe(name, price, size, ingredients.length);
        try {
            for (Ingredient ingredient : ingredients) {
                newRecipe.addIngredient(ingredient);
            }
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients");
        }
        return newRecipe;
    }
}
