package uk.ac.sheffield.com1003.cafe;

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        Recipe small = new Recipe("Espresso", 1.5);
        cafe.addRecipe(small);

        Recipe regular = new Recipe("Espresso", 2.2);
        cafe.addRecipe(regular);

        Recipe large = new Recipe("Espresso", 2.5);
        cafe.addRecipe(large);
    }
}
