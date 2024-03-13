package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

public class App
{
    public static void main(String[] args)
    {
        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);

        Recipe largeSoyLatte = new Recipe("LargeSoyLatte", 2.5, Recipe.Size.LARGE, 2);

        try
        {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));

            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Milk(400, Milk.Type.SOY));
        }
        catch (TooManyIngredientsException e)
        {
            System.out.println("Too many ingredients");
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }

}