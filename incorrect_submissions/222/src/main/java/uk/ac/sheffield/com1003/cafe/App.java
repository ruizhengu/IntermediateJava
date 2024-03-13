package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

//test too many ingredients test fails but this is expected because constructors dont assign values to the name variables of the ingridient

public class App {
    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            cafe.addRecipe(espresso);

            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);

            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
            largeSoyLatte.addIngredient(new Coffee(25));
            largeSoyLatte.addIngredient(new Water(60));
            largeSoyLatte.addIngredient(new Milk(20, Milk.Type.SOY));
            cafe.addRecipe(largeSoyLatte);

        }catch (TooManyIngredientsException e){
            e.printStackTrace();
        }

        cafe.printMenu();









    }
}
