package uk.ac.sheffield.com1003.cafe.solution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.sheffield.com1003.cafe.Cafe;
import uk.ac.sheffield.com1003.cafe.Recipe;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestCafeRemoveRecipe {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    protected Recipe createEspressoRecipe() {
        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Coffee());
            espresso.addIngredient(new Water());
            return espresso;
        } catch (TooManyIngredientsException exc) {
            System.err.println(exc.getMessage());
            return null;
        }
    }

    protected Recipe createEspressoRecipeAlt() {
        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
            espresso.addIngredient(new Water());
            espresso.addIngredient(new Coffee());
            return espresso;
        } catch (TooManyIngredientsException exc) {
            System.err.println(exc.getMessage());
            return null;
        }
    }

    @Test
    public void testRemoveNonexistentRecipeIncorrectException() {
        Cafe cafe = new Cafe("Central Perk", 10, 10);
        cafe.addRecipe(createEspressoRecipe());
        try {
            cafe.removeRecipeSolution("Dummy Recipe");
            fail("It should have thrown RecipeNotFoundException");
        } catch (RecipeNotFoundException e) {
            // OK
        }
    }

    @Test
    public void testRemoveNonexistentRecipe() {
        try {
            Cafe cafe = new Cafe("Central Perk", 10, 10);
            cafe.addRecipe(createEspressoRecipe());
            cafe.removeRecipeSolution("Dummy Recipe");
            fail("It should have thrown RecipeNotFoundException");
        } catch (Exception thrown) {
            assertEquals("uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException", thrown.getClass().getName());
        }
    }

    @Test
    public void testRemoveRecipe() throws TooManyIngredientsException, RecipeNotFoundException {
        Cafe cafe = new Cafe("Central Perk", 10, 10);
        assertEquals(0, cafe.getMenu().length);
        Recipe justWater = new Recipe("Just Water", 0, Recipe.Size.SMALL, 1);
        justWater.addIngredient(new Water());
        cafe.addRecipe(justWater);
        assertEquals(1, cafe.getMenu().length);
        cafe.removeRecipeSolution("Just Water");
        assertEquals(0, cafe.getMenu().length);
    }

    @Test
    public void testRemoveMiddleRecipe() throws TooManyIngredientsException, RecipeNotFoundException {
        Cafe cafe = new Cafe("Central Perk", 10, 10);
        cafe.addRecipe(createEspressoRecipe());

        Recipe justWater = new Recipe("Just Water", 0, Recipe.Size.SMALL, 1);
        justWater.addIngredient(new Water());
        cafe.addRecipe(justWater);

        Recipe americano = new Recipe("Americano", 2, Recipe.Size.REGULAR, 2);
        americano.addIngredient(new Coffee());
        americano.addIngredient(new Water());
        cafe.addRecipe(americano);

        assertEquals(3, cafe.getMenu().length);
        cafe.removeRecipeSolution("Just Water");
        cafe.removeRecipeSolution("Americano");
        cafe.removeRecipeSolution("Espresso");
        assertEquals(0, cafe.getMenu().length);
    }

    @Test
    public void testRemoveAllRecipes() throws TooManyIngredientsException, RecipeNotFoundException {
        Cafe cafe = new Cafe("Central Perk", 10, 10);
        cafe.addRecipe(createEspressoRecipe());

        Recipe justWater = new Recipe("Just Water", 0, Recipe.Size.SMALL, 1);
        justWater.addIngredient(new Water());
        cafe.addRecipe(justWater);

        cafe.addRecipe(createEspressoRecipeAlt());

        cafe.removeRecipeSolution("Espresso");
        assertEquals(2, cafe.getMenu().length);
    }
}
