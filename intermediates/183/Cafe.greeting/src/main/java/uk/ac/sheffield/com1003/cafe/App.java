package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;
//task 1:
public class App {
    
public static void main(String[] args) {
    Cafe c = new Cafe();
    Recipe espresso = new Recipe("Espresso", 1.5, Size.SMALL, 2);
    Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Size.REGULAR,2);
    Recipe soyLate = new Recipe("Large Soy Late", 2.5, Size.LARGE, 2);

    c.addRecipe(espresso);
    c.addRecipe(doubleEspresso);
    c.addRecipe(soyLate);
    

//adding the ingredients
try {
    espresso.addIngredient(new Coffee());
    espresso.addIngredient(new Water());
    doubleEspresso.addIngredient(new Coffee(20));
    doubleEspresso.addIngredient(new Water(40));
    soyLate.addIngredient(new Coffee(50));
    soyLate.addIngredient(new Milk(120,Milk.Type.SOY));
    
}
catch(TooManyIngredientsException expt){
    System.out.println("An Exception: There Are Too Many Ingredients!!");

}

c.printMenu();
c.printPendingOrders();
}
}