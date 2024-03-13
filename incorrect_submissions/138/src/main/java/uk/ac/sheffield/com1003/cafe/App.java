package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException {
        Cafe myCafe = new Cafe("My Cafe", 3, 100);
        
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        espresso.addIngredient(new Water(30));
        espresso.addIngredient(new Coffee(8, false));
        myCafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2); 
        doubleEspresso.addIngredient(new Water(50));
        doubleEspresso.addIngredient(new Coffee(15, false));
        myCafe.addRecipe(doubleEspresso);
        
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        largeSoyLatte.addIngredient(new Water(50));
        largeSoyLatte.addIngredient(new Coffee(15, false));
        largeSoyLatte.addIngredient(new Milk(200, Type.SOY));
        myCafe.addRecipe(largeSoyLatte);
    }
}
