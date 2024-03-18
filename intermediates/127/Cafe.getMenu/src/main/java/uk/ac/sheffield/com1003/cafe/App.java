package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException{
        Cafe firstCafe = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        espresso.addIngredient(new Water());
        espresso.addIngredient(new Coffee(8, false));

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Water(50));
        doubleEspresso.addIngredient(new Coffee(15, false));

        Recipe largeSoyLatte = new Recipe("largeSoyLatte", 2.5, Size.LARGE, 3);
        largeSoyLatte.addIngredient(new Water(50));
        largeSoyLatte.addIngredient(new Coffee(15, false));
        largeSoyLatte.addIngredient(new Milk(50, Type.SOY));

       
        firstCafe.addRecipe(espresso);
        firstCafe.addRecipe(doubleEspresso);    
        firstCafe.addRecipe(largeSoyLatte);

        firstCafe.printMenu();
        firstCafe.placeOrder("Espresso", "Steven", 3);
        firstCafe.printPendingOrders();;
    }
}