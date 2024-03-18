/**
 * App.java
 * 
 * Runs an instance of Cafe.java
 * 
 * @version 1.0 08/03/23
 * @author Adam Willis
 */

package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

    public static void main(String[] args) {
        
        Cafe myCafe = new Cafe("The Espresso Express");

        Recipe espressoRecipe = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        try {
            espressoRecipe.addIngredient(new Water());
            espressoRecipe.addIngredient(new Coffee());
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added");
        }
        
        Recipe doubleEspressoRecipe = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        try {
            doubleEspressoRecipe.addIngredient(new Water(50));
            doubleEspressoRecipe.addIngredient(new Coffee(15));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added");
        }

        Recipe largeSoyLatteRecipe = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        try {
            largeSoyLatteRecipe.addIngredient(new Water(50));
            largeSoyLatteRecipe.addIngredient(new Coffee(15));
            largeSoyLatteRecipe.addIngredient(new Milk(100, Milk.Type.SOY)); 
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients added");
        }

        if (myCafe.addRecipe(espressoRecipe)) {
            System.out.println(espressoRecipe.getName()+" added succesfully");
        }
        if (myCafe.addRecipe(doubleEspressoRecipe)) {
            System.out.println(doubleEspressoRecipe.getName()+" added succesfully");
        }
        if (myCafe.addRecipe(largeSoyLatteRecipe)) {
            System.out.println(largeSoyLatteRecipe.getName()+" added succesfully");
        }
        
        myCafe.printMenu();

    }  
}
