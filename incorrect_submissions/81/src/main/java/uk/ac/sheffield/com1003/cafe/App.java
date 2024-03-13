package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Coffee Shop");


        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Recipe DoubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe LargeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);


        //add ingredients to recipe and test against TooManyIngredients exception
        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            DoubleEspresso.addIngredient(new Coffee(15, false));
            DoubleEspresso.addIngredient(new Water());

            LargeSoyLatte.addIngredient(new Coffee());
            LargeSoyLatte.addIngredient(new Milk(100, Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println(e);
        }


        //Add recipes to cafe
        cafe.addRecipe(espresso);
        cafe.addRecipe(DoubleEspresso);
        cafe.addRecipe(LargeSoyLatte);
        

        cafe.printMenu();
        

    }
}
