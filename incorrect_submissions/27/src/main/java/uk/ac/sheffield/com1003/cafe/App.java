package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Cafe cafe = new Cafe();
			Recipe expresso = new Recipe("Espresso", 1.5, Size.SMALL,2);
			expresso.addIngredient(new Coffee());
			expresso.addIngredient(new Water());
			cafe.addRecipe(expresso);
			
			Recipe doubleExpresso = new Recipe("Double Espresso", 2.2, Size.REGULAR,2);
			doubleExpresso.addIngredient(new Coffee(15));
			doubleExpresso.addIngredient(new Water(50));
			cafe.addRecipe(doubleExpresso);
			
			Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 1);
			soyLatte.addIngredient(new Milk(1000, Type.SOY));
			cafe.addRecipe(soyLatte);
			cafe.printMenu();
		}
		catch(TooManyIngredientsException tmie){
			System.out.println("Failed to add ingredient "+tmie.getIngredient().getName()+" as there is already the max amount of ingredients in the recipe.");
		}
		
	}

}
