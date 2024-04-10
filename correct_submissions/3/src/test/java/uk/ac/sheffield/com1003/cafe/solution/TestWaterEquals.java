package uk.ac.sheffield.com1003.cafe.solution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestWaterEquals {

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
    public void testWaterEqualsItself() {
        Water water1 = new Water();
        Water water2 = new Water();
        assertTrue(water1.equalsSolution(water2));
    }

    @Test
    public void testWaterEqualsNull() {
        Water water1 = new Water();
        assertFalse(water1.equalsSolution(null));
    }

    @Test
    public void testWaterDifferentAmount() {
        Water water1 = new Water(10);
        Water water2 = new Water(20);
        assertFalse(water1.equalsSolution(water2));
    }
}
