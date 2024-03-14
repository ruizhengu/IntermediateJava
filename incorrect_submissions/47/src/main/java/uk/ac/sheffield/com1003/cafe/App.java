package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
       try{
           Cafe cafe = new Cafe();
            // Add Espresso, Double Espresso and Large Soy Latte to menu
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            cafe.addRecipe(espresso);

            Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            cafe.addRecipe(doubleEspresso);

            Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
            soyLatte.addIngredient(new Milk(20, Milk.Type.SOY));
            soyLatte.addIngredient(new Coffee());
            soyLatte.addIngredient(new Water());
            cafe.addRecipe(soyLatte);
            cafe.printMenu();
            cafe.placeOrder(soyLatte.getName(), "Mike", 3.0);
       } catch (TooManyIngredientsException e) {
           System.out.println("Sorry, you've already added too many ingredients");
       } catch (CafeOutOfCapacityException e) {
        System.out.println("We apologize, we have " + e.getMaxCapacity() + " orders to serve right now, we are so busy today that we cannot serve you this order.");
        // throw new CafeOutOfCapacityException();
       } catch (RecipeNotFoundException e) {
        System.out.println("Sorry, the recipe " + "\"" + e.getUnknownRecipe() + "\"" + " does not exist in our menu.");
        // throw new RecipeNotFoundException();
    }
    }
}
