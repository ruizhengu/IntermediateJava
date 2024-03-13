package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args){

        //A new Cafe instance
        Cafe cafe = new Cafe();

        //Espresso
        Ingredient coffee = new Coffee(); //default amount 8gr
        Ingredient water  = new Water();  //default amount 30ml
        Recipe espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL,2);

        //Double Espresso
        Ingredient coffeeDouble = new Coffee(15);
        Ingredient waterDouble = new Water(50);
        Recipe doubleEspresso = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);

        //large soy latte
        Ingredient soyMilk = new Milk(Milk.Type.SOY);
        Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE,3);

        //Catch an exception if number of ingredients exceeds
        try{
            espresso.addIngredient(coffee);
            espresso.addIngredient(water);

            doubleEspresso.addIngredient(coffeeDouble);
            doubleEspresso.addIngredient(waterDouble);

            largeSoyLatte.addIngredient(coffeeDouble);
            largeSoyLatte.addIngredient(waterDouble);
            largeSoyLatte.addIngredient(soyMilk);
        } catch (TooManyIngredientsException e){
            System.out.println("You have added too many ingredients");
        }

        //Add Recipe's to cafe
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();







    }
}
