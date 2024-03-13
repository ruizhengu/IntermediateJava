package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) throws Exception {
        Cafe currentCafe = new Cafe("the Cozy Corner", 3, 1000);

        Recipe espressoRecipe = new Recipe("Espresso", 1.50, Recipe.Size.SMALL, 2);
        espressoRecipe.addIngredient(new Coffee());
        espressoRecipe.addIngredient(new Water());
        currentCafe.addRecipe(espressoRecipe);

        Recipe doubleEspressoRecipe = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspressoRecipe.addIngredient(new Coffee(15));
        doubleEspressoRecipe.addIngredient(new Water(50));
        currentCafe.addRecipe(doubleEspressoRecipe);

        Recipe largeSoyRecipe = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        largeSoyRecipe.addIngredient(new Milk(20, Milk.Type.SOY));
        largeSoyRecipe.addIngredient(new Coffee(20));
        largeSoyRecipe.addIngredient(new Water(30));
        currentCafe.addRecipe(largeSoyRecipe);

        currentCafe.printMenu();

    }
}
