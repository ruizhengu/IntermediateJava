package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
//completed Tasks: 1,2,3,4,5
//uncompleted tasks: 6,7
//tests passed: 4/7


public class App{
    public static void main(String[]args){
        Cafe newCafe = new Cafe("Anya's Cafe");
        //espresso
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL,2);
        //ingredients
        try{
            espresso.addIngredient(new Coffee(8, false));
            espresso.addIngredient(new Water());
        }catch(TooManyIngredientsException e){
            System.out.println(e.getMessage());
        }
        
        //double espresso
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2,Size.REGULAR, 2);
        //ingredients
        try{
            doubleEspresso.addIngredient(new Coffee(15,false));
            doubleEspresso.addIngredient(new Water(50));
        }catch(TooManyIngredientsException e){
            System.out.println(e.getMessage());
        }

        //Large soy latte
        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        //ingredients
        try{
            largeSoyLatte.addIngredient(new Coffee(20,false));
            largeSoyLatte.addIngredient(new Milk(250, Type.SOY));
        }catch(TooManyIngredientsException e){
            System.out.println(e.getMessage());
        }

        //Add recipes
        newCafe.addRecipe(espresso);
        newCafe.addRecipe(doubleEspresso);
        newCafe.addRecipe(largeSoyLatte);

        //Print menu
        
        newCafe.printMenu();

        //TESTING
        try{
            newCafe.placeOrder("Espresso", "customerName", 1.5);
        }catch(RecipeNotFoundException e){
            System.out.println(e.getMessage());
        }catch(CafeOutOfCapacityException e){
            System.out.println(e.getMessage());
        }
        
    }
}