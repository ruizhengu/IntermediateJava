package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App  {
    public static void main(String[] args) throws TooManyIngredientsException {

        //create new cafe
        Cafe cafeMenu = new Cafe();

        //create recipe espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.REGULAR, 2);
        //add coffee
        espresso.addIngredient(new Coffee());
        //add water
        espresso.addIngredient(new Water());
        //add recipe to menu
        cafeMenu.addRecipe(espresso);

        //create recipe double espresso
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.SMALL, 2);
        //add specific amount of coffee
        doubleEspresso.addIngredient(new Coffee(15));
        //add specific amount of water
        doubleEspresso.addIngredient(new Water(50));
        //add recipe to menu
        cafeMenu.addRecipe(doubleEspresso);

        Recipe latte = new Recipe("Latte", 2.5, Recipe.Size.LARGE, 2);
        latte.addIngredient(new Coffee());
        latte.addIngredient(new Milk(100, Milk.Type.SOY));
        cafeMenu.addRecipe(latte);

        }

    }

