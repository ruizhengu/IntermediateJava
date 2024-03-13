package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
//import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
//import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) {
        
        Cafe myCafe = new Cafe("myCafe");
        
        Recipe espressoRecipe = new Recipe("Espresso",1.5,Size.SMALL, 2);
        Ingredient waterEmpty = new Water();
        Ingredient coffeeEmpty = new Coffee();

        Recipe doubleEspressoRecipe = new Recipe("Double Espresso",2.2,Size.REGULAR, 2);
        Ingredient water50ml = new Water(50);
        Ingredient coffee15gFalse = new Coffee(15,false);

        Recipe largeSoyLatteRecipe = new Recipe("Large Soy Latte",2.5,Size.LARGE, 3);
        Ingredient milk50mlSoy = new Milk(50,Type.SOY);
        

        myCafe.addRecipe(espressoRecipe);
        myCafe.addRecipe(doubleEspressoRecipe);
        myCafe.addRecipe(largeSoyLatteRecipe);
        

        try {
            espressoRecipe.addIngredient(waterEmpty);
        } catch (TooManyIngredientsException e){
            System.out.println("TooManyIngredientsException caught");
        }
        try {
            espressoRecipe.addIngredient(coffeeEmpty);
        } catch (TooManyIngredientsException e){
            System.out.println("TooManyIngredientsException caught");
        }
        try {
            doubleEspressoRecipe.addIngredient(water50ml);
        } catch (TooManyIngredientsException e){
            System.out.println("TooManyIngredientsException caught");
        }
        try {
            doubleEspressoRecipe.addIngredient(coffee15gFalse);
        } catch (TooManyIngredientsException e){
            System.out.println("TooManyIngredientsException caught");
        }
        try {
            largeSoyLatteRecipe.addIngredient(waterEmpty);
        } catch (TooManyIngredientsException e){
            System.out.println("TooManyIngredientsException caught");
        }
        try {
            largeSoyLatteRecipe.addIngredient(coffeeEmpty);
        } catch (TooManyIngredientsException e){
            System.out.println("TooManyIngredientsException caught");
        }
        try {
            largeSoyLatteRecipe.addIngredient(milk50mlSoy);
        } catch (TooManyIngredientsException e){
            System.out.println("TooManyIngredientsException caught");
        }
        
        
        myCafe.printMenu();
        

    }
        
}