package uk.ac.sheffield.com1003.cafe;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.ingredients.*;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;

public class App {
    public static void main(String[] args) {

        Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
        Ingredient[] espressoIng= { new Coffee(), new Water() };
        addIngredients(espresso, espressoIng);

        Recipe doubleEspresso = new Recipe("Double Espresso", 2.2, Recipe.Size.REGULAR, 2);
        Ingredient[]  doubleEspressoIng = { new Coffee(15, false), new Water(50)};
        addIngredients(doubleEspresso, doubleEspressoIng);

        Recipe largeSoyLatte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 2);
        Ingredient[] largeSoyLatteIng = {new Milk(100, Milk.Type.SOY )};
        addIngredients(largeSoyLatte, largeSoyLatteIng);

        Recipe[] recipes = {espresso, doubleEspresso, largeSoyLatte};
        Cafe cafe = new Cafe();
        makeMenu(cafe, recipes);
        cafe.printMenu();
    }

    /**
     * Add an array of ingredients to a recipe.
     *
     * @param recipe The recipe to add ingredients to.
     * @param ingredients The ingredients to add.
     */
    public static void addIngredients(Recipe recipe, Ingredient[] ingredients){
        for(Ingredient i : ingredients){
            try{
                recipe.addIngredient(i);
            } catch (TooManyIngredientsException e){
                System.out.println("Too many ingredients while making " + recipe.getName());
            } catch (Exception e) {
                System.out.println("Error while adding ingredients to" + recipe.getName() + ": " + e);
            }
        }
    }

    /**
     * Adds recipes to a cafe from a list of recipes.
     *
     * @param cafe The cafe to add recipes too.
     * @param recipes The recipes to add.
     */
    public static void makeMenu(Cafe cafe, Recipe[] recipes){
        for(Recipe r : recipes){
            cafe.addRecipe(r);
        }
    }
}
