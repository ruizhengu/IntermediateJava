package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {

    public static void main(String args[]){
        Cafe cafe = new Cafe("leblanc",3,100);

        Recipe Espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL,2);

        try {
            Espresso.addIngredient(new Coffee());
        } catch (Exception TooManyIngredientsException){}

        try {
            Espresso.addIngredient(new Water());
        } catch (Exception TooManyIngredientsException){}

        cafe.addRecipe(Espresso);

        Recipe Double_Espresso = new Recipe("Double Espresso",2.2, Recipe.Size.REGULAR,2);

        try {
            Double_Espresso.addIngredient(new Coffee(15, false));
        } catch (Exception TooManyIngredientsException){}

        try {
            Double_Espresso.addIngredient(new Water(50));
        } catch (Exception TooManyIngredientsException){}
        cafe.addRecipe(Double_Espresso);

        Recipe Large_Soy_Latte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE,3);

        try {
            Large_Soy_Latte.addIngredient(new Milk(150, Milk.Type.SOY));
        } catch (Exception TooManyIngredientsException){}

        try {
            Large_Soy_Latte.addIngredient(new Coffee(25, false));
        } catch (Exception TooManyIngredientsException){}

        try {
            Large_Soy_Latte.addIngredient(new Water(50));
        } catch (Exception TooManyIngredientsException){}

        cafe.addRecipe(Large_Soy_Latte);

        cafe.printMenu();

    }
}
