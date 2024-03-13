package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;

public class App {
    
    public static void main(String[] args) {

        /* Task 1 */
        
        //sizeMenu: 10, orderCapacity: 100
        Cafe cafe = new Cafe("The Coffee Place");

        Recipe espresso = new Recipe("Espresso", 1.50, Size.SMALL, 2);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.20, Size.REGULAR, 2);

        Recipe soyLatte = new Recipe("Large Soy Latte", 2.50, Size.LARGE, 2);


        //Add ingredients to the recipes, with exception handling
        try {

            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));

            soyLatte.addIngredient(new Milk(100, Type.SOY));
            soyLatte.addIngredient(new Coffee(8, false));

        }
        catch (TooManyIngredientsException e) {
            System.out.println("You have tried to add more ingredients than the recipe allows");
        }

        //Add recipes to the menu
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(soyLatte);



        /* Task 2 */

        cafe.printMenu();

        //End of main method
    }

}
