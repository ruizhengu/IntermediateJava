package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;


public class App extends Cafe {
    public App(String name, int capacity, int cash) {
        super(name, capacity, cash);
    }

    public static void main(String[] args) throws TooManyIngredientsException { /*Create an instance to initailise the cafe */

        Cafe cafe = new Cafe("Central Park", 2,1);

        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL,2);/*make espresso recipe*/
        espresso.addIngredient(new Coffee(8,false));
      espresso.addIngredient(new Water(30));
        cafe.addRecipe(espresso);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR,2);/*make double Espresso Recipe*/
        doubleEspresso.addIngredient(new Coffee(15,false));
        doubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(doubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE,2);/*make Large Soy Latte Recipe*/
        largeSoyLatte.addIngredient(new Coffee(8,true));
        largeSoyLatte.addIngredient(new Milk(8, Milk.Type.SOY));
        cafe.addRecipe(largeSoyLatte);


        Recipe americano = new Recipe("Americano", 2, Size.REGULAR, 2);
        americano.addIngredient(new Coffee());
        americano.addIngredient(new Water());
        cafe.addRecipe(americano);

        cafe.printMenu();
    }
}
