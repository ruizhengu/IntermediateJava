package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.ingredients.*;


public class App {
    public static void main(String[] args) {
        
        Cafe cafe = new Cafe("COM1003 Cafe");

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Recipe largeSoyLatte = new Recipe ("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);

        //Add ingredients for Espresso
        try{
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
        }
        catch (Exception e){
            System.out.println("Too many ingredients!");
        }

        //Add ingredients for Double Espresso
        try{
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        }
        catch (Exception e){
            System.out.println("Too many ingredients!");
        }

        //Add ingredients for Large Soy Latte
        try{
            largeSoyLatte.addIngredient(new Coffee(15));
            largeSoyLatte.addIngredient(new Milk(100, Milk.Type.SOY));
        }
        catch (Exception e){
            System.out.println("Too many ingredients!");
        }

        cafe.addRecipe(espresso);
        cafe.addRecipe(doubleEspresso);
        cafe.addRecipe(largeSoyLatte);

        cafe.printMenu();
    }
}