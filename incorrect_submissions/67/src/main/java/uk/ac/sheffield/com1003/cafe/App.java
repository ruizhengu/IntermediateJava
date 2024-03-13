package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String args[]){

        //Creating a new Café object called withThreeDrinks and the name of the Café is Jake's Café
        Cafe jakesCafe = new Cafe("Jake's Cafe");

        //Create three new Recipe objects with their corresponding parameters
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);

        Recipe nespresso = new Recipe("Nespresso", 1.5, Recipe.Size.SMALL, 2); //delete

        //Instantiating new ingredient classes
        Coffee coffee = new Coffee();
        Water water = new Water();
        Coffee moreCoffee = new Coffee(15);
        Water moreWater = new Water(50);
        Milk soyMilk = new Milk(100, Milk.Type.SOY);
        Syrup caramel = new Syrup();

        //adding ingredients to the recipes and catching any exceptions
        try {
            espresso.addIngredient(coffee);
            espresso.addIngredient(water);
            doubleEspresso.addIngredient(moreCoffee);
            doubleEspresso.addIngredient(moreWater);
            largeSoyLatte.addIngredient(soyMilk);
            largeSoyLatte.addIngredient(caramel);

            nespresso.addIngredient(coffee);//delete
            nespresso.addIngredient(water);//delete
        } catch (TooManyIngredientsException TMIE) {
            System.out.println("That's too many ingredients");
        }

        //Adding the three new Recipe objects to the new Café object called jakesCafe using the method addRecipe
        jakesCafe.addRecipe(espresso);
        jakesCafe.addRecipe(doubleEspresso);
        jakesCafe.addRecipe(largeSoyLatte);

        jakesCafe.printMenu();

        //Placing an order and catching any exceptions if they are thrown - works
        try {
            jakesCafe.placeOrder("Espresso", "Jake", 2.5);
            jakesCafe.placeOrder("Large Soy Latte", "Mike", 2.8);
        }
        catch (RecipeNotFoundException NFE) {
            System.out.println("The recipe name does not exist in the menu");
        }
        catch (CafeOutOfCapacityException OOCE) {
            System.out.println("The cafe cannot take any more orders and is out of capacity");
        }

        jakesCafe.printPendingOrders();

        Recipe.equals(espresso, nespresso); //test recipe equals method


    }
}
