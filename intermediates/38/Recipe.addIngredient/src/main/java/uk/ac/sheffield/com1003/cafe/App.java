package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App{

    public static void main(){
        Cafe cafe = new Cafe();

        Recipe espresso = new Recipe("Espresso",1.5,Size.SMALL,2);
        try{
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        }
        catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients attempted to be added");
        }
        cafe.addRecipe(espresso);

        Recipe dblEspresso = new Recipe("Double Espresso",2.2,Size.REGULAR,2);
        try{
            dblEspresso.addIngredient(new Coffee(15,false));
            dblEspresso.addIngredient(new Water(50));
        }
        catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients attempted to be added");
        }
        cafe.addRecipe(dblEspresso);

        Recipe lrgSoyLatte = new Recipe("Large Soy Latte",2.5,Size.LARGE,3);
        try{
            lrgSoyLatte.addIngredient(new Coffee());
            lrgSoyLatte.addIngredient(new Water());
            lrgSoyLatte.addIngredient(new Milk(300,Type.SOY));
        }
        catch (TooManyIngredientsException e){
            System.out.println("Too many ingredients attempted to be added");
        }
        cafe.addRecipe(lrgSoyLatte);

        cafe.printMenu();
    }
}