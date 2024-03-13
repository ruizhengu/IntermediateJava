package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
/* Imports all necessary variables/objects */


public class App {

    public static void main(String[] args) throws Exception{

        Cafe Cafe = new Cafe("Cafe",10,100);

        Recipe espressoRecipe = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Coffee Coffee = new Coffee(8,  false);
        Water Water = new Water(30);
        /* Creates espresso recipe and adds/initialises ingredients to recipe */
        espressoRecipe.addIngredient(Coffee);
        espressoRecipe.addIngredient(Water);

        Recipe doubleEspressoRecipe = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Coffee = new Coffee(15,  false);
        Water = new Water(50);
        /* Creates double espresso recipe and adds/initialises ingredients to recipe */
        doubleEspressoRecipe.addIngredient(Coffee);
        doubleEspressoRecipe.addIngredient(Water);

        Recipe largeSoyLatteRecipe = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        Coffee = new Coffee(15,  false);
        Water = new Water(50);
        Milk Milk = new Milk(100, Type.SOY);
        /* Creates soy latte recipe and adds/initialises ingredients to recipe */
        largeSoyLatteRecipe.addIngredient(Coffee);
        largeSoyLatteRecipe.addIngredient(Water);
        largeSoyLatteRecipe.addIngredient(Milk);
   
        Cafe.addRecipe(espressoRecipe);
        Cafe.addRecipe(doubleEspressoRecipe);
        Cafe.addRecipe(largeSoyLatteRecipe);
        /* Adds each recipe to menu */

        Cafe.printMenu();
        
    }
}
