package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Mr. Bean");

     // Create Espresso recipe
        Recipe espresso = new Recipe("Espresso", 1.5);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());	
        } catch(TooManyIngredientsException e){
        	System.out.println("there have been too many ingredient");
        }
        cafe.addRecipe(espresso);
        
        // Create Double Espresso recipe
    	Recipe doubleEspresso = new Recipe("Double Espresso", 2.2);
        try {
        	doubleEspresso.addIngredient(new Coffee(15, true));
        	doubleEspresso.addIngredient(new Water(50));	
        } catch(TooManyIngredientsException e){
        	System.out.println("there have been too many ingredient");
        }
        cafe.addRecipe(doubleEspresso);
        
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5);
        try {
            largeSoyLatte.addIngredient(new Coffee(10, true));
            largeSoyLatte.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Milk(200, Type.SOY));
        } catch(TooManyIngredientsException e){
        	System.out.println("there have been too many ingredient");
        }
        cafe.addRecipe(largeSoyLatte);
        
        Recipe largeSoyLatte2 = new Recipe("Large Soy Latte 2", 2.5);
        try {
        	largeSoyLatte2.addIngredient(new Coffee(10, true));
        	largeSoyLatte2.addIngredient(new Water(50));
        	largeSoyLatte2.addIngredient(new Milk(200, Type.SOY));
        } catch(TooManyIngredientsException e){
        	System.out.println("there have been too many ingredient");
        }
        cafe.addRecipe(largeSoyLatte2);
        
        cafe.printMenu();
        
        try{
        	cafe.placeOrder("Espresso", "Jose", 3);
        } catch (RecipeNotFoundException e ) {
        	System.out.println("this is not one of our recipe's");
        }catch(CafeOutOfCapacityException e){
        	System.out.println("there have been too many orders or we cant proses any more");
        }
        
        cafe.printPendingOrders();
        System.out.println(cafe.serveOrder());
        System.out.println(largeSoyLatte.equals(largeSoyLatte2));
        
    }
}
