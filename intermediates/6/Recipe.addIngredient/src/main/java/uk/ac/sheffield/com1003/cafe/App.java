package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;


public class App {
    public static void main (String [] args) throws TooManyIngredientsException {
        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL,2);
        try{
            //tests if the recipe is within the ingredients list
            espresso.addIngredient(new Coffee(8, false));
            espresso.addIngredient(new Water());
        }
        catch(TooManyIngredientsException tmi){
            //if not then it would be caught by the exception
            System.out.println("Recipe not found");
        }


        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR,2);
        try{
            //tests if the recipe is within the ingredients list
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Water(50));
        }
        catch(TooManyIngredientsException tmi){
            //if not then it would be caught by the exception
            System.out.println("Recipe not found");
        }

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE,2);

        try{
            //tests if the recipe is within the ingredients list
            doubleEspresso.addIngredient(new Coffee(15, false));
            doubleEspresso.addIngredient(new Milk(50, Milk.Type.SOY));
        }
        catch(TooManyIngredientsException tmi){
            //if not then it would be caught by the exception
            System.out.println("Recipe not found");
        }

        cafe.addRecipe(espresso); //adds espresso to the recipe list
        cafe.addRecipe(doubleEspresso); //adds doubleEspresso to the recipe list
        cafe.addRecipe(largeSoyLatte); //adds largeSoyLatte to the recipe list
        cafe.printMenu(); //prints the menu
    }
}