package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import java.security.cert.CertSelector;

public class App {

    public static void main(String[] args){

        //Named the cafe to ensure that the greeting() message successfully outputs "Jonny's Cafe"
        Cafe cafe = new Cafe("Jonny's Cafe");

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            //Whenever adding a new ingredient the possibilty for the TooManyIngredientsException could be thrown and therefore must be caught with valid response
            espresso.addIngredient(new Coffee(8,false));
            espresso.addIngredient(new Water());

            //This last add ingredient should be ignored with the correct output proving the exception was caught
            espresso.addIngredient(new Milk());
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many Ingredients added!");
        }

        //After I have initialised the recipe as well as added all possible ingredients I want to actually add said ingredient into the cafe
        cafe.addRecipe(espresso);

        Recipe d_espresso = new Recipe("Double Espresso",2.2,Recipe.Size.REGULAR,2);
        try {
            espresso.addIngredient(new Coffee(15,false));
            espresso.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many Ingredients added!");

        }
        cafe.addRecipe(d_espresso);

        Recipe l_soy_latte = new Recipe("Large Soy Latte",2.5,Recipe.Size.LARGE,2);
        try {
            l_soy_latte.addIngredient(new Milk(10, Milk.Type.SOY));
            l_soy_latte.addIngredient(new Coffee(8,false));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many Ingredients added!");
        }
        cafe.addRecipe(l_soy_latte);

        cafe.printMenu();

        System.out.println("");

        try {
            cafe.placeOrder("Espresso","Jonny",1.7);

            //A large soy latte costs 2.5 and so I wanted to run this line to check that the order wouldnt be placed as only 1.7 was payed
            cafe.placeOrder("Large Soy Latte","Tom",1.7);

            //Then here should work as 3.0 was paid and I wanted to verify the method as whole worked.
            cafe.placeOrder("Large Soy Latte","Tom",3.0);
        } catch (RecipeNotFoundException e) {
            System.out.println("Not known recipe!");
        } catch (CafeOutOfCapacityException e) {
            System.out.println("Cafe at max capacity!");
        }

        //After testing all three ordering calls I wanted to check which of them successfully placed. Expected: 2
        cafe.printPendingOrders();

        System.out.println("");
        try {
            cafe.removeRecipe("Double Espresso");
        } catch (RecipeNotFoundException e) {
            System.out.println("Not known recipe!");
        }

        //Finally one last printMenu() call to ensure the double espresso had successfully been removed.
        cafe.printMenu();
    }

}