package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;


import static java.text.DateFormat.*;
import static uk.ac.sheffield.com1003.cafe.Recipe.Size.*;

public class App {

    public static void main (String[]args) throws RecipeNotFoundException, CafeOutOfCapacityException, TooManyIngredientsException {

        Cafe cafe = new Cafe();
        Order order = new Order();

        // Create the espresso recipe
        Recipe espresso = new Recipe("Espresso", 1.5, SMALL, 2);
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients in the recipe.");
        }
        cafe.addRecipe(espresso);

        // Create the double espresso recipe
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, REGULAR, 2);
        try{
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        } catch ( TooManyIngredientsException e){
            System.out.println("Too many ingredients in the recipe");
        }
       cafe.addRecipe(doubleEspresso);

        // Create the large soy latte recipe
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, LARGE, 3 );
        try{
            largeSoyLatte.addIngredient(new Coffee(4));
            largeSoyLatte.addIngredient(new Milk(300, Milk.Type.SOY));
            largeSoyLatte.addIngredient(new Syrup(10, "Honey"));
        } catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients in the recipe");
        }
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();

    }
}
