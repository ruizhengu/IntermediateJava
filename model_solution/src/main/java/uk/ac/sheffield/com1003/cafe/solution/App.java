package uk.ac.sheffield.com1003.cafe.solution;

import uk.ac.sheffield.com1003.cafe.solution.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Milk;

public class App {
    public static void main(String[] args) throws Exception {
        Cafe cafe = new Cafe("Central Perk");
        String name = "Espresso";
        double price = 1.5;
        Size size = Size.SMALL;
        int n = 2;
        Recipe espresso = new Recipe(name, price, size, n);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);

        Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        soyLatte.addIngredient(new Coffee());
        soyLatte.addIngredient(new Water());
        soyLatte.addIngredient(new Milk(100, Type.SOY));
        cafe.addRecipe(soyLatte);

        cafe.printMenu();
    }
}
