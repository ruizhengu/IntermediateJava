package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[]args){

        Cafe myCafe = new Cafe("Jacks Cafe");
        //creation of new recipes
        Recipe espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL,2);
        Recipe doubleEspresso = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE,3);

        //creation of the new ingredients
        Coffee smallCoffee = new Coffee(8,false);
        Coffee regularCoffee = new Coffee(15,false);
        Coffee largeCoffee = new Coffee(22,false);
        Water smallWater = new Water();
        Water regularWater = new Water(50);
        Milk largeSoyMilk = new Milk(70, Milk.Type.SOY);

        //adding the ingredients to the recipes
        try {
            espresso.addIngredient(smallCoffee);
            espresso.addIngredient(smallWater);
            doubleEspresso.addIngredient(regularCoffee);
            doubleEspresso.addIngredient(regularWater);
            largeSoyLatte.addIngredient(largeSoyMilk);
            largeSoyLatte.addIngredient(largeCoffee);
        } catch (TooManyIngredientsException e) {
          System.out.println("too many ingredients!");
        }



            myCafe.addRecipe(espresso);
            myCafe.addRecipe(doubleEspresso);
            myCafe.addRecipe(largeSoyLatte);
            myCafe.printMenu();
    }
}
