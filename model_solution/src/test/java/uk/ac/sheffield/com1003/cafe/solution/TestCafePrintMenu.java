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
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCafePrintMenu {

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

    protected ArrayList<String> getOutLines() {
        String[] lines = outContent.toString().split("\\r?\\n");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(lines));
        return arrayList;
    }

    @Test
    public void testPrintMenuExactFormat() throws Exception {
        Cafe cafe = new Cafe("Central Perk");

        Recipe espresso = createEspressoRecipe();
        cafe.addRecipe(espresso);

        Recipe americano = new Recipe("Americano", 2, Recipe.Size.REGULAR, 2);
        americano.addIngredient(new Coffee());
        americano.addIngredient(new Water());
        cafe.addRecipe(americano);

        cafe.printMenuSolution();
        ArrayList<String> lines = getOutLines();
        assertEquals(8, lines.size());
        assertEquals("==========", lines.get(0));
        assertEquals("Welcome to Central Perk", lines.get(1));
        assertEquals("Menu", lines.get(2));
        assertEquals("==========", lines.get(3));
        assertEquals("Espresso - 1.5", lines.get(4));
        assertEquals("Americano - 2.0", lines.get(5));
        assertEquals("==========", lines.get(6));
        assertEquals("Enjoy!", lines.get(7));
    }

    @Test
    public void testPrintMenuIncorrectFormat() throws Exception {
        Cafe cafe = new Cafe("Central Perk");

        Recipe espresso = createEspressoRecipe();
        cafe.addRecipe(espresso);

        Recipe americano = new Recipe("Americano", 2, Recipe.Size.REGULAR, 2);
        americano.addIngredient(new Coffee());
        americano.addIngredient(new Water());
        cafe.addRecipe(americano);

        cafe.printMenuSolution();
        ArrayList<String> lines = getOutLines();
        assertTrue(lines.stream().anyMatch(item -> item.contains("Central Perk")));
        assertTrue(lines.stream().anyMatch(item -> item.contains("Menu")));
        // using relax separator between name and price for recipes:
        assertTrue(lines.stream().anyMatch(item -> item.matches("Espresso.*1\\.5")));
        assertTrue(lines.stream().anyMatch(item -> item.matches("Americano.*2\\.0")));
        assertTrue(lines.stream().anyMatch(item -> item.contains("Enjoy")));
    }

}
