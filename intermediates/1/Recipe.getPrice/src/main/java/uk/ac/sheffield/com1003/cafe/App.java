package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

import static uk.ac.sheffield.com1003.cafe.Recipe.Size.*;

public class App {

    public static void main(String[] args) throws TooManyIngredientsException {


        Cafe cafe = new Cafe();


        Recipe espresso = new Recipe("Espresso", 1.5,SMALL,2);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2,REGULAR,2);
        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5,LARGE,3);
        largeSoyLatte.addIngredient(new Coffee(30));
        largeSoyLatte.addIngredient(new Water(100));
        largeSoyLatte.addIngredient(new Milk(40, Milk.Type.SOY));
        cafe.addRecipe(largeSoyLatte);


       cafe.printMenu();

        }
    }

