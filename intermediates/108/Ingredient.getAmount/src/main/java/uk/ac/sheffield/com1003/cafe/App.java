
package uk.ac.sheffield.com1003.cafe;

        import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
        import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
        import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
        import uk.ac.sheffield.com1003.cafe.ingredients.Water;
        import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
        import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;

public class App {

    public static void main(String[] args) {

        // Create a new Cafe instance
        Cafe cafe = new Cafe("The Best Cafe");

        // Add an Espresso recipe to the menu
        Recipe espresso = new Recipe("Espresso",1.5, Recipe.Size.SMALL, 2);
        try {
            espresso.addIngredient(new Coffee(8));
            espresso.addIngredient(new Water(30));
        }
        catch (TooManyIngredientsException e ){
            System.out.println("too many ingredients");
        }
        cafe.addRecipe(espresso);

        // Add a Double Espresso recipe to the menu
        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        try {
            doubleEspresso.addIngredient(new Coffee(15));
            doubleEspresso.addIngredient(new Water(50));
        }
        catch (TooManyIngredientsException e ){
            System.out.println("too many ingredients");
        }

        cafe.addRecipe(doubleEspresso);

        // Add a Large Soy Latte recipe to the menu
        Recipe largeSoyLatte = new Recipe("Large Soy Latte",2.5, Recipe.Size.LARGE, 3);
        try {
            largeSoyLatte.addIngredient(new Coffee());
            largeSoyLatte.addIngredient(new Water());
            largeSoyLatte.addIngredient(new Milk(200, Milk.Type.SOY));
        }
        catch (TooManyIngredientsException e ){
            System.out.println("too many ingredients");
        }
        cafe.addRecipe(largeSoyLatte);

        // Print the cafe menu
        cafe.printMenu();
    }

}