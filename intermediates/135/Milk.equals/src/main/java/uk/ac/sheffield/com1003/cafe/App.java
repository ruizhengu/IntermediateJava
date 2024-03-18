package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException, RecipeNotFoundException, CafeOutOfCapacityException {
        //Initialize & add recipes
        Cafe cafe = new Cafe("the Random Cafe",33,6);


        Recipe Espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL,2);
        Espresso.addIngredient(new Syrup());
        Espresso.addIngredient(new Water());
        cafe.addRecipe(Espresso);

        Recipe DoubleEspresso = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);
        DoubleEspresso.addIngredient(new Coffee(15,false));
        DoubleEspresso.addIngredient(new Water(50));
        cafe.addRecipe(DoubleEspresso);

        Recipe LargeSoyLatte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE,3);
        LargeSoyLatte.addIngredient(new Milk(35, Milk.Type.SOY));
        LargeSoyLatte.addIngredient(new Coffee(20,false));
        LargeSoyLatte.addIngredient(new Water(5));
        cafe.addRecipe(LargeSoyLatte);

        cafe.printMenu();

//        cafe.placeOrder("Espresso", "Jose", 3);
//        cafe.placeOrder("Espresso", "JoJo", 2);
//        cafe.placeOrder("Large Soy Latte", "Jose", 4.60);
//        cafe.placeOrder("Large Soy Latte", "Bean", 120);
//        cafe.placeOrder("Double Espresso", "Jose", 2.5);
//        cafe.serveOrder();
//        cafe.serveOrder();
//        cafe.serveOrder();
//        cafe.printPendingOrders();
//        cafe.serveOrder();
//        cafe.serveOrder();
//
//        Recipe a = new Recipe("Zen Star", 2, Recipe.Size.REGULAR, 4);
//        a.addIngredient(new Coffee(22,false));
//        a.addIngredient(new Milk(22, Milk.Type.SOY));
//        a.addIngredient(new Syrup(22,"Rotten"));
//        a.addIngredient(new Water(22));
//        cafe.addRecipe(a);
//
//        Recipe b = new Recipe("L-Star", 2, Recipe.Size.REGULAR, 4);
//        b.addIngredient(new Syrup(22,"Rotten"));
//        b.addIngredient(new Coffee(22,false));
//        b.addIngredient(new Milk(22, Milk.Type.SOY));
//        b.addIngredient(new Water(22));
//        cafe.addRecipe(b);
//
//        if(a.equals(b)){
//            System.out.println("Wow, look at all these STARs...");
//        }else{
//            System.out.println("Nope, not matching");
//        }

    }
}
