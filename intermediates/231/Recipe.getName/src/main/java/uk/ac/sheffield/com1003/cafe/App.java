package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {
    public static void main(String[] args) {

        // Create cafe object using constructor from Cafe class
        Cafe cafe = new Cafe("BarStucks", 10, 10);

        // Create recipe for Espresso with default amount of ingredients and add to menu
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException tmie) {
            System.out.println("The amount of ingredients exceeds that of the pre-defined recipe!");
        }
        cafe.addRecipe(espresso);

        // Create recipe for Double Espresso with specific size and amount of ingredients and add to menu
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException tmie) {
            System.out.println("The amount of ingredients exceeds that of the pre-defined recipe!");
        }
        cafe.addRecipe(doubleEspresso);

        // Create recipe for Large Soy Latte with custom size and amount of ingredients and add to menu
        Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        try {
            soyLatte.addIngredient(new Coffee(20));
            soyLatte.addIngredient(new Water(40));
            soyLatte.addIngredient(new Milk(40, Milk.Type.SOY));
        } catch (TooManyIngredientsException tmie) {
            System.out.println("The amount of ingredients exceeds that of the pre-defined recipe!");
        }
        cafe.addRecipe(soyLatte);

        // Print the menu which follows the format from TestCafe.java
        cafe.printMenu();
    }

}
