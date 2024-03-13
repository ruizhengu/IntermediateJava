package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main() throws TooManyIngredientsException {
        Cafe caff = new Cafe("caff");
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        caff.addRecipe(espresso);
        Recipe double_espresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        double_espresso.addIngredient(new Coffee(15));
        double_espresso.addIngredient(new Water(50));
        caff.addRecipe(double_espresso);
        Recipe soy_latte =   new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        soy_latte.addIngredient(new Milk(50, Type.SOY));
        soy_latte.addIngredient(new Water(200));
        soy_latte.addIngredient(new Coffee());
        caff.addRecipe(soy_latte);

    }
    
}
