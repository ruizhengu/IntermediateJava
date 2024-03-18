package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Ingredient;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {

    //construct Espresso
        Ingredient espressoCoffee = new Coffee(8,false);
        Ingredient espressoWater = new Water("water",30);
        Recipe espresso = new Recipe("Espresso", 1.5,Size.SMALL,2);
        try{        
            espresso.addIngredient(espressoCoffee);
            espresso.addIngredient(espressoWater);
        }catch(TooManyIngredientsException e){
            System.out.print("Espresso make Exception thrown  :" + e);
        }

    //construct doubleEspresso
        Ingredient doubleEspressoCoffee = new Coffee(15);
        Ingredient doubleEspressoWater = new Water(50);
        Recipe doubleEspresso = new Recipe("DoubleEspresso", 2.2,Size.REGULAR,2);
        try{        
            doubleEspresso.addIngredient(doubleEspressoCoffee);
            doubleEspresso.addIngredient(doubleEspressoWater);
        }catch(TooManyIngredientsException e){
            System.out.print("Double Espresso make Exception thrown  :" + e);
        }

    //construct Large Soy Latte
        Ingredient largeSoyLatteCoffee = new Coffee(99);
        Ingredient largeSoyLatteMilk = new Milk(1,Milk.Type.SOY);
        Ingredient largeSoyLatteWater = new Water(100);
        Recipe largeSoyLatte = new Recipe("largeSoyLatte", 2.5,Size.LARGE,3);
        try{
            largeSoyLatte.addIngredient(largeSoyLatteWater);
            largeSoyLatte.addIngredient(largeSoyLatteCoffee);
            largeSoyLatte.addIngredient(largeSoyLatteMilk);
        }catch(TooManyIngredientsException e){
            System.out.print("Large Soy Latte make Exception thrown  :" + e);
        }

    //construct Cafe
        Cafe Cafe = new Cafe();
        Cafe.addRecipe(largeSoyLatte);
        Cafe.addRecipe(espresso);
        Cafe.addRecipe(doubleEspresso);
    
    //call the cafe menu
        Cafe.printMenu();


    }
}
