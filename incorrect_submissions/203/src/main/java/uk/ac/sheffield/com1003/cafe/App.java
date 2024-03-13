package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;


public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Cafe", 3, 100);
        
        // created three recipes and added each ingredient 
        
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        try {// to prevent user from adding too many ingredients 
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            } catch (TooManyIngredientsException e) {
                System.out.println("Too Many Ingredients");
            }
        

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15,false));
            doubleEspresso.addIngredient(new Water(50));
            } catch (TooManyIngredientsException e) {
                System.out.println("Too Many Ingredients");
            }
      

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        try {
        largeSoyLatte.addIngredient(new Milk(10, Type.SOY));
        largeSoyLatte.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            System.out.println("Too Many Ingredients");
        }
        
    
    
    }
}
