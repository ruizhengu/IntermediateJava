package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main (String args[]){

        //Instantiation of cafe and Recipe objects

        Cafe cafeOne = new Cafe("cafeOne");
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR,
         2 );
        Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        
        //Adding ingredients to recipes
        // Try and catch needed due to possibble exception
        try {
            espresso.addIngredient(new Water());
            espresso.addIngredient(new Coffee());            
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            soyLatte.addIngredient(new Milk(50, Milk.Type.SOY));
            soyLatte.addIngredient(new Water(50));
            soyLatte.addIngredient(new Coffee(15));
             
        } catch (TooManyIngredientsException e) {
            System.out.println("Error: Too many ingredients") ;        
        }

        //Adding recipes to cafe

        cafeOne.addRecipe(espresso);
        cafeOne.addRecipe(doubleEspresso);
        cafeOne.addRecipe(soyLatte);
        
        cafeOne.printMenu();
 
    }
}
