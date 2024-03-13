package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {
    public static void main(String[]args){
        Cafe c1 = new Cafe();

        Recipe drink1 = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Coffee coffee1 = new Coffee();
        Water water1 = new Water();

        try{
            drink1.addIngredient(coffee1);
            drink1.addIngredient(water1);
        }catch(TooManyIngredientsException e){
            System.out.println("You've added too many ingredients!");
        }
        c1.addRecipe(drink1);
        

        Recipe drink2 = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Coffee coffee2 = new Coffee(15);
        Water water2 = new Water(50);

        try{
            drink2.addIngredient(coffee2);
            drink2.addIngredient(water2);
        }catch(TooManyIngredientsException e){
            System.out.println("You've added too many ingredients!");
        }
        c1.addRecipe(drink2);


        Recipe drink3 = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        Milk milk = new Milk(100, Type.SOY);
        Coffee coffee3 = new Coffee(30);

        try{
            drink3.addIngredient(milk);
            drink3.addIngredient(coffee3);
        }catch(TooManyIngredientsException e){
            System.out.println("You've added too many ingredients!");
        }
        c1.addRecipe(drink3);

        c1.printMenu();
    }
}
