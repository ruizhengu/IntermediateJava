package uk.ac.sheffield.com1003.cafe.solution;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.sheffield.com1003.cafe.Cafe;
import uk.ac.sheffield.com1003.cafe.Order;
import uk.ac.sheffield.com1003.cafe.Recipe;
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
import static org.junit.Assert.assertNull;

public class TestCafePlaceOrder {


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

    protected void resetOutLines() {
        outContent.reset();
    }

    @Test
    public void printPendingOrderSingle() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 2, 1);
        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrderSolution("Espresso", "Jose", 3);
        cafe.printPendingOrders();
        ArrayList<String> lines = getOutLines();
        assertEquals(2, lines.size());
        assertEquals("Pending Orders:", lines.get(0));
        assertEquals("Order: Espresso; For: Jose; Paid: 3.0", lines.get(1));
    }

    @Test
    public void printPendingOrdersMultiple() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 2, 2);
        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrderSolution("Espresso", "Jose", 3);
        cafe.placeOrderSolution("Espresso", "Mari-Cruz", 5);
        cafe.printPendingOrders();
        ArrayList<String> lines = getOutLines();
        assertEquals(3, lines.size());
        assertEquals("Pending Orders:", lines.get(0));
        assertEquals("Order: Espresso; For: Jose; Paid: 3.0", lines.get(1));
        assertEquals("Order: Espresso; For: Mari-Cruz; Paid: 5.0", lines.get(2));
    }

    @Test
    public void printPendingOrdersAfterServing() throws Exception {
        // Handout is unspecific obout what to print if there are no pending orders,
        // so anything could be found here, but check that
        Cafe cafe = new Cafe("Central Perk", 2, 2);
        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrderSolution("Espresso", "Mari-Cruz", 5);
        cafe.placeOrderSolution("Espresso", "Jose", 3);
        cafe.serveOrder();
        cafe.printPendingOrders();
        ArrayList<String> lines = getOutLines();
        assertEquals(2, lines.size());
        assertEquals("Pending Orders:", lines.get(0));
        assertEquals("Order: Espresso; For: Jose; Paid: 3.0", lines.get(1));
    }

    @Test
    public void printPendingOrderSingleRelaxed() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 2, 1);
        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrderSolution("Espresso", "Jose", 3);
        cafe.printPendingOrders();
        ArrayList<String> lines = getOutLines();
        assertTrue(lines.stream().anyMatch(item -> item.toUpperCase().matches(".*PENDING.*ORDERS.*")));
        assertTrue(lines.stream().anyMatch(item -> item.toUpperCase().matches(".*ORDER.*ESPRESSO.*FOR.*JOSE.*PAID.*3.*")));
    }

    @Test
    public void printPendingOrdersEmpty() throws Exception {
        // Handout is unspecific obout what to print if there are no pending orders,
        // so anything could be found here, so we can only check that the output
        // is consistent regardless of the number of placed and served orders
        Cafe cafe = new Cafe("Central Perk", 2, 2);
        cafe.printPendingOrders();
        ArrayList<String> firstPrint = getOutLines();
        resetOutLines();

        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrderSolution("Espresso", "Mari-Cruz", 5);
        cafe.serveOrder();
        cafe.printPendingOrders();
        ArrayList<String> secondPrint = getOutLines();
        resetOutLines();

        cafe.placeOrderSolution("Espresso", "Jose", 3);
        cafe.serveOrder(); // both orders served, no pending order left
        cafe.printPendingOrders();
        ArrayList<String> thirdPrint = getOutLines();
        resetOutLines();
        assertEquals(firstPrint, secondPrint);
        assertEquals(secondPrint, thirdPrint);
    }

    @Test
    public void placeOrder() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 1);
        cafe.addRecipe(createEspressoRecipe());
        assertTrue(cafe.placeOrderSolution("Espresso", "Jose", 3));
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
        assertFalse(cafe.placeOrderSolution("Espresso", "Jose", 1));
        Order[] orders = (Order[]) FieldUtils.readField(cafe, "orders", true);
        assertNull(orders[0]);
    }

    @Test(expected = Exception.class)
    public void placeOrderForNonexistentRecipeThrowsException() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 1);
        cafe.addRecipe(createEspressoRecipe()); // Price is 1.5
        cafe.placeOrderSolution("Flat white", "Jose", 10);
    }

    @Test(expected = RecipeNotFoundException.class)
    public void placeOrderForNonexistentRecipeThrowsCorrectException() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 1);
        cafe.addRecipe(createEspressoRecipe()); // Price is 1.5
        cafe.placeOrderSolution("Flat white", "Jose", 10);
    }

    @Test
    public void placeOrderAndCheckIndexes() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 1, 1);
        cafe.addRecipe(createEspressoRecipe());
        assertTrue(cafe.placeOrderSolution("Espresso", "Jose", 3));
        int indexPlace = (int) FieldUtils.readField(cafe, "indexNextOrderToPlace", true);
        int indexServe = (int) FieldUtils.readField(cafe, "indexNextOrderToServe", true);
        assertEquals(1, indexPlace);
        assertEquals(0, indexServe);
    }

    @Test
    public void placeAndServeOrder() throws Exception {
        Cafe cafe = new Cafe("Central Perk", 2, 1);
        cafe.addRecipe(createEspressoRecipe());
        assertTrue(cafe.placeOrderSolution("Espresso", "Jose", 3));
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
        cafe.placeOrderSolution("Espresso", "Jose", 3);
    }

    @Test(expected = CafeOutOfCapacityException.class)
    public void placeOrderCapacityZeroThrowsCorrectException() throws RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe("Central Perk", 2, 0);
        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrderSolution("Espresso", "Jose", 3);
    }

    @Test(expected = Exception.class)
    public void placeOrderOutOfCapacityThrowsException() throws RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe("Central Perk", 2, 1);
        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrderSolution("Espresso", "Jose", 3);
        cafe.placeOrderSolution("Espresso", "Mari-Cruz", 5);
    }

    @Test(expected = CafeOutOfCapacityException.class)
    public void placeOrderOutOfCapacityThrowsCorrectException() throws RecipeNotFoundException, CafeOutOfCapacityException {
        Cafe cafe = new Cafe("Central Perk", 2, 1);
        cafe.addRecipe(createEspressoRecipe());
        cafe.placeOrderSolution("Espresso", "Jose", 3);
        cafe.placeOrderSolution("Espresso", "Mari-Cruz", 5);
    }
}
