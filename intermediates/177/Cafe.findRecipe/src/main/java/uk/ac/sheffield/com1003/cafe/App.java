package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
        // Create a new Cafe instance
        Cafe cafe = new Cafe();

        new Coffee(8, false);
        new Water(30);
        Recipe espresso = new Recipe("Espresso", 1.5);
        cafe.addRecipe(espresso);

        new Coffee(15, false);
        new Water(50);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2);
        cafe.addRecipe(doubleEspresso);

        new Milk(200);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5);
        cafe.addRecipe(largeSoyLatte);

        // Print the menu
        cafe.printMenu();
    }
}




