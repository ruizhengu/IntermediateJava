package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) {
        // creating cafe
        Cafe cafe = new Cafe();
        
        // adding 3 drinks for task 1
        // creating and adding Espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            System.out.println("You have exceeded the amount of ingredients in 1st recipe");
        }
        cafe.addRecipe(espresso);
        
        // creating and adding Double Espresso
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            System.out.println("You have exceeded the amount of ingredients in the 2nd recipe");
        }
        cafe.addRecipe(doubleEspresso);
        
        // creating and adding Large Soy Latte
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        try {
            largeSoyLatte.addIngredient(new Coffee(10));
            largeSoyLatte.addIngredient(new Milk(115,Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("You have exceeded the amount of ingredients in the 3rd recipe");
        }
        cafe.addRecipe(largeSoyLatte);
        
        // task 2
        cafe.printMenu();
    }
}
