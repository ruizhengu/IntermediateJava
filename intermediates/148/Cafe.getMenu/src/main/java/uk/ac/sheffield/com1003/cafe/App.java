package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;


public class App {
    public static void main(String[] args){


        try{
            //Create three instances and add corresponding ingredients
            Cafe cafe = new Cafe("Central Perk",10,100);

            Recipe Espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL,2);
            Espresso.addIngredient(new Coffee(8,true));
            Espresso.addIngredient(new Water(30));

            Recipe Double_Espresso = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);
            Double_Espresso.addIngredient(new Coffee(15,true));
            Double_Espresso.addIngredient(new Water(50));

            Recipe Large_Soy_Latte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE,3);
            Large_Soy_Latte.addIngredient(new Milk(8, Milk.Type.SOY));
            Large_Soy_Latte.addIngredient(new Coffee(8,true));
            Large_Soy_Latte.addIngredient(new Water(30));

            //add and print menu
            cafe.addRecipe(Espresso);
            cafe.addRecipe(Double_Espresso);
            cafe.addRecipe(Large_Soy_Latte);
            cafe.printMenu();

            //Place an order and print pending order
            cafe.placeOrder("Espresso","Jose",2.2);
            cafe.printPendingOrders();

            //Remove Recipe and print menu again
            cafe.removeRecipe("Espresso");
            cafe.printMenu();
        }catch(TooManyIngredientsException e){
            e.printStackTrace();
        }catch(RecipeNotFoundException e){
            e.printStackTrace();
        }catch(CafeOutOfCapacityException e){
            e.printStackTrace();
        }




    }
}
