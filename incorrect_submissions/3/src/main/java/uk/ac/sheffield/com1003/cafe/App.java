package uk.ac.sheffield.com1003.cafe;


import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class App {
    public static void main(String[] args) throws TooManyIngredientsException{

        Cafe MyCafe = new Cafe("My Cafe");

        Recipe largeSoyLate = new Recipe("Large Soy latte", 2.5,Size.LARGE,1);
        largeSoyLate.addIngredient(new Coffee(15,false));
        largeSoyLate.addIngredient(new Milk(100,Type.SOY));
        largeSoyLate.addIngredient(new Milk(110,Type.SOY));
        MyCafe.addRecipe(largeSoyLate);
        
        Recipe largeSoyLate2 = new Recipe("Large Soy Latte 2", 2.5,Size.LARGE,1);
        largeSoyLate2.addIngredient(new Milk(110,Type.SOY));
        largeSoyLate2.addIngredient(new Milk(110,Type.SOY));
        largeSoyLate2.addIngredient(new Coffee(15,false));

        MyCafe.addRecipe(largeSoyLate2);


        MyCafe.printMenu();
        try{

            MyCafe.removeRecipe("Large Soy Latte 2");
        }catch(Exception e){

        }
        MyCafe.printMenu();
    }
}
