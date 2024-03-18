package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {

    /**
     * @return returns {@link Recipe} object with name "Espresso", price of £1.5, small size and
     * 2 ingredients: coffee and water (both with default values).
     */
    public static Recipe createEspressoRecipe() {
        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            return espresso;
        } catch (TooManyIngredientsException e) {
            System.out.println(e.getClass());
        }
        return null;
    }

    /**
     * @return returns {@link Recipe} object with name "Double Espresso", price of £2.2, regular size and
     * 2 ingredients (coffee (15g non decaf) and water (50ml)).
     */
    public static Recipe createDoubleEspressoRecipe() {
        try {
            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
            return doubleEspresso;
        } catch (TooManyIngredientsException e) {
            System.out.println(e.getClass());
        }
        return null;
    }

    /**
     * @return returns {@link Recipe} object with name "Large Soy Latte", price of £2.5, large size and
     * 3 ingredients: coffee (default), water (default) and milk (soy).
     */
    public static Recipe createLargeSoyLatteRecipe() {
        try {
            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Water());
            largeSoyLatte.addIngredient(new Milk(Type.SOY));
            return largeSoyLatte;
        } catch (TooManyIngredientsException e) {
            System.out.println(e.getClass());
        }
        return null;
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe();

        Recipe[] drinks = {createEspressoRecipe(), createDoubleEspressoRecipe(), createLargeSoyLatteRecipe()};

        for (int i=0; i<drinks.length; i++) {
            cafe.addRecipe(drinks[i]);
        }
        cafe.printMenu();
    }
}
