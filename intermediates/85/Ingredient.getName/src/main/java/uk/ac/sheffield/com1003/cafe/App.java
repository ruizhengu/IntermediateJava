package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        //Creating recipes and adding relevant ingredients to them
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);

        handleAddingRecipes(new Ingredient[]{new Coffee(), new Water()}, espresso);
        handleAddingRecipes(new Ingredient[]{new Coffee(15), new Water(50)}, doubleEspresso);
        handleAddingRecipes(new Ingredient[]{new Coffee(5), new Water(50),
                new Milk(75, Milk.Type.SOY)}, largeSoyLatte);

        //Adding recipes to the cafe
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }

    public static void handleAddingRecipes(Ingredient[] ingredients, Recipe recipe) {
        for(Ingredient ingredient : ingredients){
            try {
                recipe.addIngredient(ingredient);
            } catch (TooManyIngredientsException e) {
                System.out.println("Error: There are too many ingredients in that recipe!"
                        + "Try to change number of ingredients of " + recipe.getName());
                System.out.println("Ingredient which could not be added: " + ingredient.getName());
            }
        }
    }
}
