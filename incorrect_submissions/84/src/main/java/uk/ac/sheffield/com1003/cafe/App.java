package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;


//TASK 1
public class App {

    public static void main(String[] args) throws TooManyIngredientsException,RecipeNotFoundException,CafeOutOfCapacityException {

            Cafe cafe = new Cafe();

            Recipe Espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            Water w1 = new Water();
            Coffee c1 = new Coffee();
            Espresso.addIngredient(w1);
            Espresso.addIngredient(c1);
            cafe.addRecipe(Espresso);

            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            Water w2 = new Water(50);
            Coffee c2 = new Coffee(15, false);
            doubleEspresso.addIngredient(w2);
            doubleEspresso.addIngredient(c2);
            cafe.addRecipe(doubleEspresso);

            Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
            Milk soy = new Milk(100, Milk.Type.SOY);
            largeSoyLatte.addIngredient(w1);
            largeSoyLatte.addIngredient(c1);
            largeSoyLatte.addIngredient(soy);
            cafe.addRecipe(largeSoyLatte);

            //TASK 2
            cafe.printMenu();


    }

}