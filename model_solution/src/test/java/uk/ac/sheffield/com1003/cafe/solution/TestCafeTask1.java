package uk.ac.sheffield.com1003.cafe.solution;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.sheffield.com1003.cafe.solution.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Water;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.solution.ingredients.Unit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCafeTask1 {

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

    protected Recipe createEspressoRecipeIncomplete() {
        try {
            Recipe espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
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

    protected void resetOutLines() {
        outContent.reset();
    }

    protected ArrayList<String> getErrLines() {
        String[] lines = errContent.toString().split("\\r?\\n");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(lines));
        return arrayList;
    }

    @Test
    public void testAppClassExists() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("uk.ac.sheffield.com1003.cafe.solution.App");
        assertNotNull(clazz);
    }

    @Test
    public void testAddRecipeAndMenuSize() throws Exception {
        Cafe cafe = new Cafe("Central Perk");
        Recipe espresso = createEspressoRecipe();
        assertTrue(cafe.addRecipe(espresso));
        Recipe americano = new Recipe("Americano", 2, Recipe.Size.REGULAR, 2);
        americano.addIngredient(new Coffee());
        americano.addIngredient(new Water());
        assertTrue(cafe.addRecipe(americano));
        assertEquals(2, cafe.getMenu().length);
    }

    @Test
    public void testAddRecipeMenuSizeZero() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 0, 10); // only one recipe can be allowed
        Recipe espresso = createEspressoRecipe();
        assertFalse(cafe.addRecipe(espresso));
        assertEquals(0, cafe.getMenu().length);
    }

    @Test
    public void testAddRecipeExceedingMenuSize() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 10); // only one recipe can be allowed
        Recipe espresso = createEspressoRecipe();
        assertTrue(cafe.addRecipe(espresso));
        Recipe americano = new Recipe("Americano", 2, Recipe.Size.REGULAR, 2);
        americano.addIngredient(new Coffee());
        americano.addIngredient(new Water());
        assertFalse(cafe.addRecipe(americano)); // should not be added
        assertEquals(1, cafe.getMenu().length);
    }

    @Test
    public void testCoffeeConstructor() throws IllegalAccessException {
        Coffee c = new Coffee();
        assertEquals("Coffee", c.getName());
        assertEquals(8, c.getAmount());
        assertEquals(Unit.GR, c.getUnit());

        // Having to use reflection because we didn't provide
        // a getter for Coffee.decaf or ask for one to be implemented
        Boolean isDecaf = (Boolean)FieldUtils.readField(c, "decaf", true);
        assertFalse(isDecaf);
    }

    @Test
    public void testCoffeeConstructorOverloaded() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        // if Coffee(int amount) has not been implemented, this will throw NoSuchMethodException
        Coffee c = ConstructorUtils.invokeConstructor(Coffee.class, 30);

        assertEquals("Coffee", c.getName());
        assertEquals(30, c.getAmount());
        assertEquals(Unit.GR, c.getUnit());
        Boolean isDecaf = (Boolean)FieldUtils.readField(c, "decaf", true);
        assertFalse(isDecaf);
    }

    @Test
    public void testWaterConstructorOverloaded() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Water w = ConstructorUtils.invokeConstructor(Water.class, 120);
        assertNotNull(w);
        assertEquals("Water", w.getName());
        assertEquals(120, w.getAmount());
        assertEquals(Unit.ML, w.getUnit());
    }

    @Test
    public void testWaterConstructor() {
        Water w = new Water();
        assertEquals("Water", w.getName());
        assertEquals(Unit.ML, w.getUnit());
    }

    @Test
    public void testTooManyIngredients() {
        Recipe latte = new Recipe("Just Water", 1, Recipe.Size.LARGE, 1);
        assertThrows(TooManyIngredientsException.class, () -> {
            latte.addIngredient(new Water());
            latte.addIngredient(new Coffee());
        });
    }

    @Test
    public void testSoyMilkOptionExists() {
        assertTrue(EnumUtils.isValidEnum(Milk.Type.class, "SOY"), "SOY does not seem to exist in Milk.Type");
    }

}
