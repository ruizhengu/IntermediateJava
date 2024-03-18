package uk.ac.sheffield.com1003.cafe;

import uk.ac.sheffield.com1003.cafe.Recipe.Size;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;
import uk.ac.sheffield.com1003.cafe.ingredients.Syrup;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

public class App {
    public static void main(String[] args) {

        //Cafe created
        Cafe casa = new Cafe("Casa");
        //Task one adding recipes to the cafe
        Recipe[] menu = {new Recipe("Espresso", 1.5, Size.SMALL, 2),
                new Recipe("Double Espresso", 2.2, Size.REGULAR, 2),
                new Recipe("Large Soy Latte", 2.5, Size.LARGE, 2)
        };

        //Task one adding the recipes to the array
        //iterating through the recipe array
        for (int i = 0; i < menu.length; i++) {
            try {
                //matches the given recipe name with the appropriate ingredients
                switch (menu[i].getName()) {
                    case "Espresso":
                        menu[i].addIngredient(new Coffee(8));
                        menu[i].addIngredient(new Water(30));
                        break;
                    case "Double Espresso":
                        menu[i].addIngredient(new Coffee(15));
                        menu[i].addIngredient(new Water(50));
                        break;
                    case "Large Soy Latte":
                        menu[i].addIngredient(new Milk(80, Type.SOY));
                        menu[i].addIngredient(new Syrup());
                        break;
                    default:
                        System.out.println("This recipe does not exist");
                }
            } catch (TooManyIngredientsException tmie) {
                System.out.println("Too many ingredients for " + menu[i].getName());
                //replace the position of this recipe with a null index
                menu[i] = null;


            }
        }
        //Task adding the recipes to the array
        for (Recipe items : menu) {
            //only add to the menu recipes that have all valid ingredients
            if (items != null && items.isReady()) {
                casa.addRecipe(items);
            } else {
                continue;
            }
        }

        //Task 2 printing the menu
        casa.printMenu();

        //Trying to place an order and catching any exception that may be thrown
        try {
            casa.placeOrder("Espresso", "Joan Kelly", 1.5);
        } catch (CafeOutOfCapacityException coc) {
        } catch (RecipeNotFoundException rnf) {
        }
        casa.printPendingOrders();
        casa.serveOrder();
        casa.printPendingOrders();


    }
}

