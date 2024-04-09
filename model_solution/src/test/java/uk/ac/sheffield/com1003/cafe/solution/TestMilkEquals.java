package uk.ac.sheffield.com1003.cafe.solution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestMilkEquals {

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
    public void testMilkEqualsItself() {
        Milk milk1 = new Milk();
        Milk milk2 = new Milk();
        assertTrue(milk1.equalsSolution(milk2));
    }

    @Test
    public void testMilkEqualsNull() {
        Milk milk = new Milk();
        assertFalse(milk.equalsSolution(null));
    }

    @Test
    public void testMilkDifferentAmount() {
        Milk milk = new Milk(10);
        Milk coffee2 = new Milk(12);
        assertFalse(milk.equalsSolution(coffee2));
    }

    @Test
    public void testMilkDifferentDecaf() {
        Milk milk = new Milk(10, Milk.Type.ALMOND);
        Milk coffee2 = new Milk(10, Milk.Type.SEMI);
        assertFalse(milk.equalsSolution(coffee2));
    }
}
