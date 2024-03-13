package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import static uk.ac.sheffield.com1003.cafe.Recipe.Size.*;

public class App {
    public static void main(String[] args) {
        try{
            Cafe cafe =new Cafe();
        /* creates the espresso recipe*/
            Recipe espresso = new Recipe("Espresso",1.5,SMALL,2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            cafe.addRecipe(espresso);
        /* creates double espresso recipe */
            Recipe doubleEspresso = new Recipe("Double Espresso",2.2,REGULAR,2);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);
        /* creates recipe for large soy latte */
            Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5,LARGE,3);
            largeSoyLatte.addIngredient(new Milk(50));
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Water());
            cafe.addRecipe(largeSoyLatte);
            cafe.placeOrder("Large Soy Latte","Test",49);
        }
        catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients for a recipe");
        }
        catch (RecipeNotFoundException e){
            System.out.println("can not find that Recipe");
        }
        catch (CafeOutOfCapacityException e) {
            System.out.println("cafe does not have enough space");
        }
        catch (Exception e) {
            System.out.println("Unexpected error");
        }
    }

}
