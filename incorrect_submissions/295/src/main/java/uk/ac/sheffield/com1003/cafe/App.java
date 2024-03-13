package uk.ac.sheffield.com1003.cafe;

public class App {

    public static void main(String[] args) {

            // Instantiating variables
            Cafe starbucks = new Cafe("Starbucks", 3, 100);
            // Is soy an extra ingredient?
            starbucks.addRecipe(new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2));
            starbucks.addRecipe(new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2));
            starbucks.addRecipe(new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3));

            starbucks.printMenu();
    }

}
