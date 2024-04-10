package uk.ac.sheffield.com1003.cafe.solution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TestCoffeeEquals {

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

    @Test
    public void testCoffeeEqualsItself() {
        Coffee coffee1 = new Coffee();
        Coffee coffee2 = new Coffee();
        assertTrue(coffee1.equalsSolution(coffee2));
    }

    @Test
    public void testCoffeeEqualsNull() {
        Coffee coffee1 = new Coffee();
        assertFalse(coffee1.equalsSolution(null));
    }

    @Test
    public void testCoffeeDifferentDecaf() {
        Coffee coffee1 = new Coffee(10, true);
        Coffee coffee2 = new Coffee(10, false);
        assertFalse(coffee1.equalsSolution(coffee2));
    }
}
