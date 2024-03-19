package uk.ac.sheffield.com1003.cafe.solution;

import uk.ac.sheffield.com1003.cafe.solution.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.solution.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Water;

/**
 * The App class is the entry point of the Cafe application. It creates a new cafe object and adds several recipes to it.
 */
public class App {
    public static void main(String[] args)  {
        Cafe myCafe = new Cafe("Starbucks");

        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            if (espresso.isReady()) {
                myCafe.addRecipe(espresso);
                System.out.println("Added Recipe-"+espresso.getName()+" successfully");
            }else{
            System.out.println("Failed to add Recipe-" +espresso.getName()+"!");
            System.out.println("Please check the completeness of the recipe.");
        }
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        try {
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            if (doubleEspresso.isReady()) {
                myCafe.addRecipe(doubleEspresso);
                System.out.println("Added Recipe-"+doubleEspresso.getName()+" successfully");
            }else{
                System.out.println("Failed to add Recipe-" +doubleEspresso.getName()+"!");
                System.out.println("Please check the completeness of the recipe.");
            }
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        try {
            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
            largeSoyLatte.addIngredient(new Coffee(20));
            largeSoyLatte.addIngredient(new Water(60));
            largeSoyLatte.addIngredient(new Milk(400, Milk.Type.SOY));
            if (largeSoyLatte.isReady()) {
                myCafe.addRecipe(largeSoyLatte);
                System.out.println("Added Recipe-"+largeSoyLatte.getName()+" successfully");
            }else{
                System.out.println("Failed to add Recipe-" +largeSoyLatte.getName()+"!");
                System.out.println("Please check the completeness of the recipe.");
            }
        } catch (TooManyIngredientsException e) {
            e.printStackTrace();
        }

        myCafe.printMenu();
    }
}