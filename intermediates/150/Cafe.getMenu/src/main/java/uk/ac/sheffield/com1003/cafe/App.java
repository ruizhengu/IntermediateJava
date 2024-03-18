package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main (String[]args) throws TooManyIngredientsException {
        Cafe cafe1 = new Cafe("Quiet Moment", 10, 100);
        Recipe recipe1 = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2 );
        Recipe recipe2 = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2 );
        Recipe recipe3 = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3 );

        recipe1.addIngredient(new Coffee());
        recipe1.addIngredient(new Water());
        cafe1.addRecipe(recipe1);

        recipe2.addIngredient(new Coffee(15, false));
        recipe2.addIngredient(new Water(50));
        cafe1.addRecipe(recipe2);

        recipe3.addIngredient(new Coffee());
        recipe3.addIngredient(new Water());
        recipe3.addIngredient(new Milk(70, Milk.Type.SOY));
        cafe1.addRecipe(recipe3);

        cafe1.printMenu();
    }
}