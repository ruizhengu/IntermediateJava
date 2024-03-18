package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

import static uk.ac.sheffield.com1003.cafe.Recipe.Size.*;
import static uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type.*;

public class App {
    private Cafe cafe;
    private Recipe espresso = new Recipe("Espresso", 1.5, SMALL, 2);
    private Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, REGULAR, 2);
    private Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5,LARGE,3);
    public void main(String[] args) throws TooManyIngredientsException {
        cafe.addRecipe(espresso);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());

        cafe.addRecipe(doubleEspresso);
        espresso.addIngredient(new Coffee(15,false));
        espresso.addIngredient(new Water(50));

        cafe.addRecipe(largeSoyLatte);
        espresso.addIngredient(new Coffee());
        espresso.addIngredient(new Water());
        espresso.addIngredient(new Milk(100,SOY));
    }
}
