package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

//Task 1
//Create App.java
public class App {
    public static void main(String args[]){
        //Create a Cafe instance and Recipe instances
        Cafe cafe = new Cafe("My Cafe",10,100);
        Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR, 2);
        Recipe soyLatte = new Recipe("Large Soy Latte", 2.5, Size.LARGE, 3);
        
        //Implement and use the method Cafe.addRecipe(Recipe newRecipe)
        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(soyLatte);

        try {
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
            soyLatte.addIngredient(new Coffee(10));
            soyLatte.addIngredient(new Water(5));
            soyLatte.addIngredient(new Milk(80, Milk.Type.SOY));
        }
        catch (TooManyIngredientsException e) {
            System.out.println("Many Ingredients Are Added");
        }

        //Task 2
        //Implement method Cafe.printMenu()
        cafe.printMenu();
    }
}
