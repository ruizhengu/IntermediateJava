package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Unit;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args){
        try {
            
        Cafe m = new Cafe("Costa" ,5, 2);

        Recipe Espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Espresso.addIngredient(new Water());
        Espresso.addIngredient(new Coffee());
        m.addRecipe(Espresso);

        Recipe DoubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        DoubleEspresso.addIngredient(new Water(50));
        DoubleEspresso.addIngredient(new Coffee(15));
       
        m.addRecipe(DoubleEspresso);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2);
        largeSoyLatte.addIngredient(new Milk(15, Type.SOY));
        largeSoyLatte.addIngredient(new Water(30));
        m.addRecipe(largeSoyLatte);


                         /*<--------------to test the equals method--------------> */ 
        

        Recipe EspressoTest = new Recipe("Normal Espresso", 1.5, Size.SMALL, 2);
        EspressoTest.addIngredient(new Water(30)); // this constructor have an UNDEFINED unit. and water.name is an empty string
        EspressoTest.addIngredient(new Coffee());
        m.addRecipe(EspressoTest);

        EspressoTest.equals(Espresso); // will return false because of the unit and water name


        Recipe EspressoTest2 = new Recipe("Normal Espresso2", 1.5, Size.SMALL, 2);
        EspressoTest2.addIngredient(new Water("Water",30,Unit.ML));// this constructor have an ML unit. and water.name is "Water"
        EspressoTest2.addIngredient(new Coffee());
        m.addRecipe(EspressoTest2);

       EspressoTest2.equals(Espresso); // will return true because the constructor set the unit and water's name

                                /*<----------------------------> */


        m.printMenu();
        m.removeRecipe("Double Espresso");
        

         Recipe normalEspresso = new Recipe("Normal Espresso3", 1.5, Size.SMALL, 2);
         normalEspresso.addIngredient(new Water(30));
         normalEspresso.addIngredient(new Coffee(8,false));
         m.addRecipe(normalEspresso);

         m.printMenu();
         
        m.placeOrder("Large Soy Latte", "yacine",5);
        m.placeOrder("Normal Espresso", "Jose", 3);

        /*m.placeOrder("Espresso", "Jose", 3);
        will throw an exception because the maximum of the orders that can be places are 2 .  */

      /*  m.placeOrder("Double Espresso", "Jose", 3);
       will throw an exception as the recipe has beeen deleted (not found)*/

        m.serveOrder();
        m.printPendingOrders();

       

        }catch (TooManyIngredientsException e) {
            System.out.println(e+ ", you exceeded the number of ingredients allowed");
        }catch(RecipeNotFoundException e){
             System.out.println(e + ", the recipe does not exist");
         }catch(CafeOutOfCapacityException e){
             System.out.println(e+", Sorry, we are out of capacity");
         }
    }
}
