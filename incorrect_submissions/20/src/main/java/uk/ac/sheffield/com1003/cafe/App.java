package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {

    /**Adding new recipes according to the params of Cafe.addRecipe*/
    public static void main(String[] arg) throws TooManyIngredientsException {
        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("doubleEspresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15,false));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("largeSoyLatte",2.5, Recipe.Size.LARGE,2);
        largeSoyLatte.addIngredient(new Milk(20, Milk.Type.SOY));
        largeSoyLatte.addIngredient(new Coffee());
        cafe.addRecipe(largeSoyLatte);

        //print the menu
        cafe.printMenu();

    }
}

