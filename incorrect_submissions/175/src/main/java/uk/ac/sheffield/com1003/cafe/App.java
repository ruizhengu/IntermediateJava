package uk.ac.sheffield.com1003.cafe;

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        cafe.addRecipe(espresso);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        cafe.addRecipe(doubleEspresso);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        cafe.addRecipe(largeSoyLatte);
        cafe.printMenu();
    }
}
