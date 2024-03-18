package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) throws RecipeNotFoundException, CafeOutOfCapacityException, TooManyIngredientsException {

        Cafe cafe = new Cafe("Pondorosa Cafe");

        /* Espresso */
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);
        
        /* Double Espresso */
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);

        /* Soy Latte */
        Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        soyLatte.addIngredient(new Coffee());
        soyLatte.addIngredient(new Water());
        soyLatte.addIngredient(new Milk(20, Type.SOY));
        cafe.addRecipe(soyLatte); 


        cafe.printMenu();
    }
}
