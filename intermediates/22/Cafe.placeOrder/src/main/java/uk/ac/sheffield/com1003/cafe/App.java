package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;

public class App {

    public static void main (String[] args) {
        //create new Cafe object
        Cafe cafe = new Cafe();

        //create new Recipe object
        Recipe espresso = new Recipe("Espresso",1.5,Recipe.Size.SMALL,1);

        //exception handling of adding ingredients
        try {
            espresso.addIngredient( new Coffee() );
            espresso.addIngredient( new Water() );
            cafe.addRecipe(espresso);
        }
        catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients");
        }

    

        Recipe doubleEspresso = new Recipe("Double Espresso",2.2,Recipe.Size.REGULAR,2);
        
        try {
            doubleEspresso.addIngredient( new Coffee(15,false) );
            doubleEspresso.addIngredient( new Water(50)) ;
            cafe.addRecipe(doubleEspresso);
        }
        catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients");
        }



        Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5,Recipe.Size.LARGE,2);

        try {
            largeSoyLatte.addIngredient( new Milk(50,Milk.Type.SOY));
            largeSoyLatte.addIngredient( new Coffee() );
            cafe.addRecipe(largeSoyLatte);
        }
        catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients");
        }


        cafe.printMenu();


    }
}
