package uk.ac.sheffield.com1003.cafe;

import javax.swing.text.StyleContext.SmallAttributeSet;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException { 
        //Creating a new instance of the cafe class
        Cafe cafe = new Cafe("my cafe",3,100);

        //Creating recipes
        Recipe Espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);

        //Add Ingredients

        //Espresso
        Water espressoWater = new Water(30);
        Espresso.addIngredient(espressoWater);

        Coffee espressoCoffee = new Coffee(8);
        Espresso.addIngredient(espressoCoffee);

        Milk espressoMilk = new Milk(100,Type.WHOLE);
        Espresso.addIngredient(espressoMilk);

        //Double Espresso
        Water doubleEspressoWater = new Water(50);
        doubleEspresso.addIngredient(doubleEspressoWater);

        Coffee doubleEspressoCoffee = new Coffee(15);
        doubleEspresso.addIngredient(doubleEspressoCoffee);

        //Large Soy Latte

        Water largeSoyLatteWater = new Water(60);
        largeSoyLatte.addIngredient(largeSoyLatteWater);

        Coffee largeSoyLatteCoffee = new Coffee(16);
        largeSoyLatte.addIngredient(largeSoyLatteCoffee);

        Milk largeSoyLatteMilk = new Milk(120, Type.SOY);
        largeSoyLatte.addIngredient(largeSoyLatteMilk);

        //Adding recipes to cafe instance
        cafe.addRecipe(Espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);
    }
}