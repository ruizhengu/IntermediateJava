package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {

        try{
            //Task 1
            Cafe myCafe = new Cafe();

            //Initialising recipe
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());

            Recipe double_espresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
            double_espresso.addIngredient(new Coffee(15));
            double_espresso.addIngredient(new Water(50));

            Recipe Soya = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
            Soya.addIngredient(new Milk(100, Milk.Type.SOY));
            Soya.addIngredient(new Water());
            Soya.addIngredient(new Coffee());

            myCafe.addRecipe(espresso);
            myCafe.addRecipe(double_espresso);
            myCafe.addRecipe(Soya);

            myCafe.printMenu();

            //------- End of Task 1 --------


            //Testing equals() method
/*            Recipe kopi = new Recipe("kokopi", 1.5, Recipe.Size.SMALL, 3);
            kopi.addIngredient(new Water());
            kopi.addIngredient(new Coffee(90));
            kopi.addIngredient(new Milk(90, Milk.Type.SKIMMED));

            Recipe kopi2 = new Recipe("kokopi", 1.5, Recipe.Size.SMALL, 3);
            kopi2.addIngredient(new Water());
            kopi2.addIngredient(new Coffee(100, true));
            kopi2.addIngredient(new Milk(100, Milk.Type.SOY));

            System.out.println(kopi.equals(kopi2));*/

            //Testing removeRecipe() method
            myCafe.removeRecipe("Espresso");
            myCafe.printMenu();

            //test place order
            myCafe.placeOrder("Double Espresso", "Jimi", 1.5);

            //test printPendingOrder() 
            myCafe.printPendingOrders();

            myCafe.serveOrder();
            myCafe.printPendingOrders();

        }
        catch(TooManyIngredientsException e){
            System.out.println("Too many Ingredient");
        }
        catch(RecipeNotFoundException e) {
            System.out.println("No such Recipe is found");
        }
        catch(CafeOutOfCapacityException e){
            System.out.println("The cafe cannot handle anymore recipe");
        }


    }
}
