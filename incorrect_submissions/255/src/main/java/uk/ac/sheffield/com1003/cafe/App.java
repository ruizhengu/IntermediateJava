package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException{
    	// create new cafe 
        Cafe cafe = new Cafe();
        
        // creating a new recipe called espresso containing 8g of coffee and 30ml of water in the recipe. Assigns it the price £1.50 and size small
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);
        
        // creating a new recipe called double espresso containing 15g of coffee and 50ml of water in the recipe. Assigns it the price £2.20 and size regular
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Coffee coffee = new Coffee(15, false);
        Water water = new Water(50);
        doubleEspresso.addIngredient(coffee);
        doubleEspresso.addIngredient(water);
        cafe.addRecipe(doubleEspresso);    
        
        // creating a new recipe called large soy latte containing 15g of coffee and 50ml of water in the recipe. Assigns it the price £2.50 and size large
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        Milk milk = new Milk(25,Milk.Type.SOY);
        largeSoyLatte.addIngredient(milk);
        largeSoyLatte.addIngredient(coffee);
        largeSoyLatte.addIngredient(water);
        cafe.addRecipe(largeSoyLatte);
        
        // prints the menu with greeting
        cafe.printMenu();
    }
}
        
        		

