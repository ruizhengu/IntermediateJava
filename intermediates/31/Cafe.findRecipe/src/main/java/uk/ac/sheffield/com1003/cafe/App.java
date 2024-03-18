package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;


public class App {
    public static void main(String[] args){
        Coffee coffee = new Coffee(15, false);
        Water water = new Water(50);
        Milk soy = new Milk(100, Milk.Type.SOY);
        
        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe dEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);

        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            dEspresso.addIngredient(coffee);
            dEspresso.addIngredient(water);
            soyLatte.addIngredient(water);
            soyLatte.addIngredient(coffee);
            soyLatte.addIngredient(soy);
        } catch (TooManyIngredientsException e) {
            System.out.println("Too many ingredients!");
        }

        Cafe shop = new Cafe("The cringe cafe");
        shop.addRecipe(espresso);
        shop.addRecipe(dEspresso);
        shop.addRecipe(soyLatte);

        shop.printMenu();
    }
}
