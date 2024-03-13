package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

    public static void main(String[] args) {
        Cafe cafe = new Cafe("cafe", 3, 10);
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water(30));
        } catch(Exception e) {
            System.out.println(e);
        }
        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch(Exception e) {
            System.out.println(e);
        }
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        try {
            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Water(50));
            largeSoyLatte.addIngredient(new Milk(10, Milk.Type.SOY));
        } catch(Exception e) {
            System.out.println(e);
        }
        cafe.addRecipe(largeSoyLatte); 

        cafe.printMenu();
    }
}
