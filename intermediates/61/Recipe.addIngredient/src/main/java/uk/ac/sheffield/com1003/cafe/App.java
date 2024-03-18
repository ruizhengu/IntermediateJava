package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) {
        //Task one




        //creating new instance of Cafe
        Cafe cafe = new Cafe();

        //creating new instance of Recipe
        Recipe espressoR = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);

        //trying to add the espresso to the recipes
        try {
            espressoR.addIngredient(new Coffee());
            espressoR.addIngredient(new Water());
        }catch (TooManyIngredientsException e){
            System.out.println(e.getMessage());
        }
        cafe.addRecipe(espressoR);


        //recipe for double espresso
        Recipe doubleEspressoR = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);

        //trying to add the item to the recipes
        try {
            doubleEspressoR.addIngredient(new Coffee(15));
            doubleEspressoR.addIngredient(new Water(50));
        } catch (TooManyIngredientsException e) {
            System.out.println(e.getMessage());
        }
        cafe.addRecipe(doubleEspressoR);

        //trying to add Large Soy Latte
        Recipe largeSoyR = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE,3);

        //trying to add the Large Soy Latte to the recipes
        try {
            largeSoyR.addIngredient(new Milk(Milk.Type.Soy));
            largeSoyR.addIngredient(new Coffee());
            largeSoyR.addIngredient(new Water());
        }catch (TooManyIngredientsException e){
            System.out.println(e.getMessage());
        }
        cafe.addRecipe(largeSoyR);



        //Task two

        cafe.printMenu();
        cafe.printPendingOrders();

    }
}
