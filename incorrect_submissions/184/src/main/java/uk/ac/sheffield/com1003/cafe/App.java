package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {
	public static void main(String[] args) {
		
		try {
		Cafe cafe = new Cafe();
		
		Recipe espresso = new Recipe("Espresso",1.5,Size.SMALL,2);
		cafe.addRecipe(espresso);
		espresso.addIngredient(new Coffee());
		espresso.addIngredient(new Water());
		
		Recipe doubleEspresso = new Recipe("Double Espresso",2.2,Size.REGULAR,2);
		cafe.addRecipe(doubleEspresso);
		espresso.addIngredient(new Coffee(15));
		espresso.addIngredient(new Water(50));
		
		Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5,Size.LARGE,2);
		cafe.addRecipe(largeSoyLatte);
		espresso.addIngredient(new Milk(50, Milk.Type.SOY));
		espresso.addIngredient(new Coffee());

		cafe.printMenu();
		
        cafe.placeOrder("Large Soy Latte", "Mark Lee", 2.5);
        cafe.placeOrder("Espresso", "Lee Haechan", 3);
        cafe.placeOrder("Double Espresso", "Na Jaemin", 3);
        cafe.placeOrder("Espresso", "Chenle", 10);
        
        cafe.printPendingOrders();             
		
       
		} catch (TooManyIngredientsException e) {
			System.err.println("Too many ingredients");
			
		} catch (CafeOutOfCapacityException e) {
			System.err.println("Cafe is out of capacity");
		
		} catch (RecipeNotFoundException e) {
			System.err.println("The recipe " + e.getString() + " is not found");
		
		}
	}
}
