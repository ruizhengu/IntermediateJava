package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main (String args[]) {
        
        Cafe Cafe = new Cafe();
        
        // Creating Espresso recipe
        Recipe Espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        try {
            Espresso.addIngredient(new Coffee());
            Espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }
        Cafe.addRecipe(Espresso);
        
        // Creating Double Espresso recipe
        Recipe DoubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        try {
            DoubleEspresso.addIngredient(new Coffee(15));
            DoubleEspresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }
        Cafe.addRecipe(DoubleEspresso);
        
        // Creating Large Soy Latter recipe
        Recipe LargeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        try {
            LargeSoyLatte.addIngredient(new Coffee(15));
            LargeSoyLatte.addIngredient(new Water(100));
            LargeSoyLatte.addIngredient(new Milk(50, Type.SOY));
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }
        Cafe.addRecipe(LargeSoyLatte);
        
        Cafe.printMenu();
    }
}
