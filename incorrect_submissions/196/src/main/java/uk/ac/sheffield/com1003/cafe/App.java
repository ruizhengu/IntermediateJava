package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;


public class App {
    Cafe cafe = new Cafe();
    private void createEspressoRecipe() throws TooManyIngredientsException {
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);
    }
    private void createDEspressoRecipe() throws TooManyIngredientsException {
        Recipe despresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        despresso.addIngredient(new Coffee(15));
        despresso.addIngredient(new Water(50));
        cafe.addRecipe(despresso);
    }
    private void createlargesoylatteRecipe() throws TooManyIngredientsException {
        Recipe largesoylatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2); 
        Milk soymilk = new Milk(200, Milk.Type.SOY);
        largesoylatte.addIngredient(new Coffee(20));
        largesoylatte.addIngredient(soymilk);
        cafe.addRecipe(largesoylatte);
    }

}
