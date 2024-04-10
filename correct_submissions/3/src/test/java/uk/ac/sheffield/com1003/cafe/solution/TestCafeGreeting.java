package uk.ac.sheffield.com1003.cafe.solution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.sheffield.com1003.cafe.Cafe;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCafeGreeting {
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
    public void testGreeting() {
        Cafe cafe = new Cafe("Central Perk");
        assertEquals(cafe.greetingSolution(), "Welcome to Central Perk");
    }

    @Test
    public void testGreetingPartial() {
        Cafe cafe = new Cafe("Central Perk");
        assertTrue(cafe.greetingSolution().contains("Welcome") || cafe.greetingSolution().contains("Central Perk"));
    }
}
