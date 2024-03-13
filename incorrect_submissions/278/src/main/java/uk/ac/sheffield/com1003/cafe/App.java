package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

public class App {
    public static void main(String[] Args) throws TooManyIngredientsException {
        //making the recipe instances (drinks)
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());

        Recipe Despresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Despresso.addIngredient(new Coffee(15,false));
        Despresso.addIngredient(new Water(30));

        Recipe Latte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        Latte.addIngredient(new Milk(100,Milk.Type.SOY));
        Latte.addIngredient(new Coffee(20,false));

        //adding recipes to café object
        Cafe s = new Cafe();
        s.addRecipe(espresso);
        s.addRecipe(Despresso);
        s.addRecipe(Latte);

        //task 2 print menu
        s.printMenu();
        s.printPendingOrders();
    }
}
