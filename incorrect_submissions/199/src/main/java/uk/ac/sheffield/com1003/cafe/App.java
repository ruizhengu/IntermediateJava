package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.*;

public class App {
    public static void main(String[] args) throws
    CafeOutOfCapacityException,
    RecipeNotFoundException,
    TooManyIngredientsException {
        Cafe myCafe = new Cafe();
        Recipe Espresso = new Recipe("Espresso",1.5,Recipe.Size.SMALL,2);
        Espresso.addIngredient(new Coffee());
        Espresso.addIngredient(new Water());
        myCafe.addRecipe(Espresso);

        Recipe DoubleEspresso = new Recipe("Double Espresso",2.2,Recipe.Size.REGULAR,2);
        DoubleEspresso.addIngredient(new Coffee(15));
        DoubleEspresso.addIngredient(new Water(50));
        myCafe.addRecipe(DoubleEspresso);

        Recipe SoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE,3);
        SoyLatte.addIngredient(new Coffee(15));
        SoyLatte.addIngredient(new Water(55));
        SoyLatte.addIngredient(new Milk(15,Milk.Type.SOY));
        myCafe.addRecipe(SoyLatte);

        myCafe.printMenu();

        


    }
}
