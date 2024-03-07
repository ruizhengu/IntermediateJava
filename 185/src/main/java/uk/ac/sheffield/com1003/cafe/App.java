package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
public class App {
    public static void main (String[] args) throws TooManyIngredientsException {
        Cafe cafe = new Cafe();
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL,2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        Cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR,2);
        doubleEspresso.addIngredient(new Coffee(15,false));
        doubleEspresso.addIngredient(new Water(50));
        Cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE,1);
        largeSoyLatte.addIngredient(new Milk(20, Milk.Type.SOY));
        Cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }
}
