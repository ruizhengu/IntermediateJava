package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
	
	public static void main(String[] args) {
		Cafe cafe = new Cafe("Cafe");
		
		Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
		Coffee defaultCoffee = new Coffee();
		
		Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
		
		Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 4);
		
		cafe.addRecipe(espresso);
		cafe.addRecipe(doubleEspresso);
		cafe.addRecipe(largeSoyLatte);
	}

}
