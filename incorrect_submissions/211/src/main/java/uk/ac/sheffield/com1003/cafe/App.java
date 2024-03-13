package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

public class App {
	  public static void main(String [] args){
		  Recipe Espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
		  Recipe Double_Espresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
		  Recipe Large_Soy_Latte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
		  
		  Cafe cafe = new Cafe();
		  Milk Soy_Milk = new Milk(100, Type.SOY);
		  Water Single_Water = new Water();
		  Water Double_Water = new Water(50);
		  Coffee Single_Shot_coffee = new Coffee();
		  Coffee Double_Shot_coffee = new Coffee(15);
		  
		  cafe.addRecipe(Espresso);
		  cafe.addRecipe(Double_Espresso);
		  cafe.addRecipe(Large_Soy_Latte);
		  
		  try {
			  Espresso.addIngredient(Single_Water);
			  Espresso.addIngredient(Single_Shot_coffee);
			  Double_Espresso.addIngredient(Double_Shot_coffee);
			  Double_Espresso.addIngredient(Double_Water);
			  Large_Soy_Latte.addIngredient(Double_Water);
			  Large_Soy_Latte.addIngredient(Double_Shot_coffee);
			  Large_Soy_Latte.addIngredient(Soy_Milk);
			  cafe.printMenu();
		  }
		  
		  catch (TooManyIngredientsException e) {
			  System.out.println("Too many ingredients");
		  }

		  
	  }
}