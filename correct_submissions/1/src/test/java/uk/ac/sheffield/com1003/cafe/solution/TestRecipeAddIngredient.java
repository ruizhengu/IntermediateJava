package uk.ac.sheffield.com1003.cafe.solution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.sheffield.com1003.cafe.Cafe;
import uk.ac.sheffield.com1003.cafe.Recipe;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRecipeAddIngredient {
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
            espresso.addIngredientSolution(new Coffee());
            espresso.addIngredientSolution(new Water());
            return espresso;
        } catch (TooManyIngredientsException exc) {
            System.err.println(exc.getMessage());
            return null;
        }
    }

    @Test
    public void testAddRecipeAndMenuSize() throws Exception {
        Cafe cafe = new Cafe("Central Perk");
        Recipe espresso = createEspressoRecipe();
        assertTrue(cafe.addRecipe(espresso));
        Recipe americano = new Recipe("Americano", 2, Recipe.Size.REGULAR, 2);
        americano.addIngredientSolution(new Coffee());
        americano.addIngredientSolution(new Water());
        assertTrue(cafe.addRecipe(americano));
        assertEquals(2, cafe.getMenu().length);
    }

    @Test
    public void testAddRecipeExceedingMenuSize() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 10); // only one recipe can be allowed
        Recipe espresso = createEspressoRecipe();
        assertTrue(cafe.addRecipe(espresso));
        Recipe americano = new Recipe("Americano", 2, Recipe.Size.REGULAR, 2);
        americano.addIngredientSolution(new Coffee());
        americano.addIngredientSolution(new Water());
        assertFalse(cafe.addRecipe(americano)); // should not be added
        assertEquals(1, cafe.getMenu().length);
    }

    @Test(expected = TooManyIngredientsException.class)
    public void testTooManyIngredients() throws TooManyIngredientsException {
        Recipe latte = new Recipe("Just Water", 1, Recipe.Size.LARGE, 1);
        latte.addIngredientSolution(new Water());
        latte.addIngredientSolution(new Coffee());
    }
}
