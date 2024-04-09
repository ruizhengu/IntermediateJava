package uk.ac.sheffield.com1003.cafe;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException;
import uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


public class TestCafeTask3 {


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

    @Test
    public void testCafeOutOfCapacityExceptionExists() {
        try {
            Class.forName("uk.ac.sheffield.com1003.cafe.exceptions.CafeOutOfCapacityException");
        } catch (ClassNotFoundException e) {
            fail("CafeOutOfCapacityException class does not exist");
        }
    }

    @Test
    public void testRecipeNotFoundExceptionExists() {
        try {
            Class.forName("uk.ac.sheffield.com1003.cafe.exceptions.RecipeNotFoundException");
        } catch (ClassNotFoundException e) {
            fail("RecipeNotFoundException class does not exist");
        }
    }

    @Test
    public void placeOrder() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 1);
        cafe.addRecipe(createEspressoRecipe());
        assertTrue(cafe.placeOrder("Espresso", "Jose", 3));
        Order[] orders = (Order[]) FieldUtils.readField(cafe, "orders", true);
        assertEquals(1, orders.length);
        Order o = orders[0];
        assertEquals("Order: Espresso; For: Jose; Paid: 3.0", o.toString());
        Object served = FieldUtils.readField(o, "orderServed", true);
        assertNull(served); // order has not been served yet
    }

    @Test
    public void placeOrderWithInsufficientFunds() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 1);
        cafe.addRecipe(createEspressoRecipe()); // Price is 1.5
        assertFalse(cafe.placeOrder("Espresso", "Jose", 1));
        Order[] orders = (Order[]) FieldUtils.readField(cafe, "orders", true);
        assertNull(orders[0]);
    }

    @Test(expected = Exception.class)
    public void placeOrderForNonexistentRecipeThrowsException() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 1);
        cafe.addRecipe(createEspressoRecipe()); // Price is 1.5
        cafe.placeOrder("Flat white", "Jose", 10);
    }

    @Test(expected = RecipeNotFoundException.class)
    public void placeOrderForNonexistentRecipeThrowsCorrectException() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 1);
        cafe.addRecipe(createEspressoRecipe()); // Price is 1.5
        cafe.placeOrder("Flat white", "Jose", 10);
    }

    @Test
    public void placeOrderAndCheckIndexes() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 1);
        cafe.addRecipe(createEspressoRecipe());
        assertTrue(cafe.placeOrder("Espresso", "Jose", 3));
        int indexPlace = (int) FieldUtils.readField(cafe, "indexNextOrderToPlace", true);
        int indexServe = (int) FieldUtils.readField(cafe, "indexNextOrderToServe", true);
        assertEquals(1, indexPlace);
        assertEquals(0, indexServe);
    }

    @Test
    public void serveNonexistentOrder() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 2, 2);
        cafe.addRecipe(createEspressoRecipe());
        Order o = cafe.serveOrder();
        assertNull(o);
        int indexPlace = (int) FieldUtils.readField(cafe, "indexNextOrderToPlace", true);
        int indexServe = (int) FieldUtils.readField(cafe, "indexNextOrderToServe", true);
        assertEquals(0, indexPlace);
        assertEquals(0, indexServe);
        Order[] orders = (Order[]) FieldUtils.readField(cafe, "orders", true);
        for (int i = 0; i < orders.length; i++) {
            assertNull(orders[i]);
        }
    }

    @Test
    public void placeAndServeOrder() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 2, 1);
        cafe.addRecipe(createEspressoRecipe());
        assertTrue(cafe.placeOrder("Espresso", "Jose", 3));
        Order o = cafe.serveOrder();
        Object served = FieldUtils.readField(o, "orderServed", true);
        assertNotNull(served); // order has been served
        int indexPlace = (int) FieldUtils.readField(cafe, "indexNextOrderToPlace", true);
        int indexServe = (int) FieldUtils.readField(cafe, "indexNextOrderToServe", true);
        assertEquals(1, indexPlace);
        assertEquals(1, indexServe);
        assertNull(cafe.serveOrder()); // cannot serve more orders
    }

    @Test(expected = Exception.class)
    public void placeOrderCapacityZeroThrowsException() throws RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe("Central Perk", 2, 0);
        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrder("Espresso", "Jose", 3);
    }

    @Test(expected = CafeOutOfCapacityException.class)
    public void placeOrderCapacityZeroThrowsCorrectException() throws RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe("Central Perk", 2, 0);
        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrder("Espresso", "Jose", 3);
    }

    @Test(expected = Exception.class)
    public void placeOrderOutOfCapacityThrowsException() throws RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe("Central Perk", 2, 1);
        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrder("Espresso", "Jose", 3);
        cafe.placeOrder("Espresso", "Mari-Cruz", 5);
    }

    @Test(expected = CafeOutOfCapacityException.class)
    public void placeOrderOutOfCapacityThrowsCorrectException() throws RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe("Central Perk", 2, 1);
        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrder("Espresso", "Jose", 3);
        cafe.placeOrder("Espresso", "Mari-Cruz", 5);
    }
}
