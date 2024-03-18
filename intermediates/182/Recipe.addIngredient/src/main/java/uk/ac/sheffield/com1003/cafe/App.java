package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.Recipe;

public class App {

    public static void main(String[] args) {

        Cafe myCafe = new Cafe();

        Recipe Espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        try {
            Espresso.addIngredient(new Water());
            Espresso.addIngredient(new Coffee());
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients exception");
        }

        Recipe dblEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            dblEspresso.addIngredient(new Water(50));
            dblEspresso.addIngredient(new Coffee(15));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients exception");
        }

        Recipe lrgSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        try {
            lrgSoyLatte.addIngredient(new Water(15));
            lrgSoyLatte.addIngredient(new Coffee(10));
            lrgSoyLatte.addIngredient(new Milk(50, Milk.Type.SOY));
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients exception");
        }

        myCafe.addRecipe(Espresso);
        myCafe.addRecipe(dblEspresso);
        myCafe.addRecipe(lrgSoyLatte);

        myCafe.printMenu();

    }
}
