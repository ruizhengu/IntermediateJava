package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException {
        //Creating a new instance of Cafe
        Cafe cafe = new Cafe ("my_cafe");

        //Adding Recipe 1 - Espresso
        Recipe espresso = new Recipe ("Espresso", 1.5, Recipe.Size.SMALL, 2);
        espresso.addIngredient(new Coffee()); //takes default amount values - 8gms
        espresso.addIngredient(new Water()); //takes default amount values - 30ml

        //Adding Recipe 2 - Double Espresso
        Recipe doubleEspresso = new Recipe ("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        doubleEspresso.addIngredient(new Coffee(15));
        doubleEspresso.addIngredient(new Water(50));

        //Adding Recipe 3 - Soy Latte
        Recipe soyLatte = new Recipe ("Large Soy Latte", 2.5,Recipe.Size.LARGE, 3 );
        soyLatte.addIngredient(new Milk(50, Milk.Type.SOY));
        soyLatte.addIngredient(new Coffee()); //takes default amount values - 8gms
        soyLatte.addIngredient(new Water()); //takes default amount values - 30ml

        //Adding the 3 recipes to the Cafe instance
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(soyLatte);

        //Calling method printMenu() from App.main
        cafe.printMenu();
    }

}
