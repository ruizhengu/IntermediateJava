package uk.ac.sheffield.com1003.cafe;

import java.lang.ProcessBuilder.Redirect.Type;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException{
        Cafe caf = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Water espressoWater = new Water();
        Coffee espCoffee = new Coffee(8, false);
        espresso.addIngredient(espCoffee);
        espresso.addIngredient(espressoWater);

        caf.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Water doubleEspWater = new Water(50);
        Coffee doubleEspCoffee = new Coffee(15);
        doubleEspresso.addIngredient(doubleEspCoffee);
        doubleEspresso.addIngredient(doubleEspWater);

        caf.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        Milk soyMilk = new Milk(3, Milk.Type.SOY);
        Water funnySoyWater = new Water(1000);
        largeSoyLatte.addIngredient(funnySoyWater);
        largeSoyLatte.addIngredient(soyMilk);

        caf.addRecipe(largeSoyLatte);

        caf.printMenu();
        
    }
}
