package uk.ac.sheffield.com1003.cafe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.sheffield.com1003.cafe.exceptions.TooManyIngredientsException;
import uk.ac.sheffield.com1003.cafe.ingredients.Coffee;
import uk.ac.sheffield.com1003.cafe.ingredients.Milk;
import uk.ac.sheffield.com1003.cafe.ingredients.Water;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestCafeTask5 {

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
    public void testRecipeEqualsItself() {
        Recipe espresso = createEspressoRecipe();
        assertEquals(espresso, espresso);
    }

    @Test
    public void testRecipeEqualsNull() {
        Recipe espresso = createEspressoRecipe();
        assertNotEquals(null, espresso);
    }

    @Test
    public void testRecipeEqualsDifferentOrderOfSameIngredients() {
        Recipe espresso = createEspressoRecipe();
        Recipe espresso2 = createEspressoRecipeAlt();
        assertEquals(espresso, espresso2);
    }

    @Test
    public void testRecipeEqualsIncompleteRecipe() {
        Recipe espresso = createEspressoRecipe();
        Recipe espressoIncomplete = createEspressoRecipeIncomplete();
        assertNotEquals(espresso, espressoIncomplete);
    }

    @Test
    public void testRecipeEqualsNoIngredients() {
        Recipe nothing = new Recipe("Nothing", 1, Recipe.Size.LARGE, 0);
        Recipe dummy = new Recipe("Dummy", 1, Recipe.Size.LARGE, 0);
        assertEquals(nothing, dummy);
    }

    @Test
    public void testRecipeNotEqualsPrice() {
        Recipe nothing = new Recipe("Nothing", 1, Recipe.Size.LARGE, 0);
        Recipe dummy = new Recipe("Nothing", 1.5, Recipe.Size.LARGE, 0);
        assertNotEquals(nothing, dummy);
    }

    @Test
    public void testRecipeNotEqualsSize() {
        Recipe nothing = new Recipe("Nothing", 1, Recipe.Size.SMALL, 0);
        Recipe dummy = new Recipe("Nothing", 1, Recipe.Size.LARGE, 0);
        assertNotEquals(nothing, dummy);
    }

    @Test
    public void testRecipeNotEqualsNotReady() {
        Recipe nothing = new Recipe("Nothing", 1, Recipe.Size.LARGE, 3);
        Recipe dummy = new Recipe("Dummy", 1, Recipe.Size.LARGE, 0);
        assertNotEquals(nothing, dummy);
    }

    @Test
    public void testRecipeMultipleIngredients() throws Exception {

        Recipe latte = new Recipe("Large Latte", 2.5, Recipe.Size.LARGE, 3);
        latte.addIngredient(new Coffee());
        latte.addIngredient(new Water());
        latte.addIngredient(new Milk(100, Milk.Type.WHOLE));

        Recipe latte2 = new Recipe("Large Latte", 2.5, Recipe.Size.LARGE, 3);
        latte2.addIngredient(new Milk(100, Milk.Type.WHOLE));
        latte2.addIngredient(new Water());
        latte2.addIngredient(new Coffee());

        assertEquals(latte, latte2);
    }

    @Test
    public void testRecipeMultipleIngredientsDifferentName() throws Exception {

        Recipe latte = new Recipe("Large Latte", 2.5, Recipe.Size.LARGE, 3);
        latte.addIngredient(new Coffee());
        latte.addIngredient(new Water());
        latte.addIngredient(new Milk(100, Milk.Type.WHOLE));

        Recipe latte2 = new Recipe("Latte Grande", 2.5, Recipe.Size.LARGE, 3);
        latte2.addIngredient(new Milk(100, Milk.Type.WHOLE));
        latte2.addIngredient(new Water());
        latte2.addIngredient(new Coffee());

        assertEquals(latte, latte2);
    }

    @Test
    public void testRecipeMultipleIngredientsDifferentCoffeeAmount() throws Exception {

        Recipe latte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        latte.addIngredient(new Coffee());
        latte.addIngredient(new Water());
        latte.addIngredient(new Milk(100, Milk.Type.WHOLE));

        Recipe latte2 = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        latte2.addIngredient(new Milk(100, Milk.Type.WHOLE));
        latte2.addIngredient(new Water());
        latte2.addIngredient(new Coffee(40, false));

        assertNotEquals(latte, latte2);
    }

    @Test
    public void testRecipeMultipleIngredientsDifferentMilkAmount() throws Exception {

        Recipe latte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        latte.addIngredient(new Coffee());
        latte.addIngredient(new Water());
        latte.addIngredient(new Milk(100, Milk.Type.WHOLE));

        Recipe latte2 = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        latte2.addIngredient(new Milk(101, Milk.Type.WHOLE));
        latte2.addIngredient(new Water());
        latte2.addIngredient(new Coffee());

        assertNotEquals(latte, latte2);
    }

    @Test
    public void testRecipeMultipleIngredientsDifferentMilkType() throws Exception {

        Recipe latte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        latte.addIngredient(new Coffee());
        latte.addIngredient(new Water());
        latte.addIngredient(new Milk(100, Milk.Type.WHOLE));

        Recipe latte2 = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        latte2.addIngredient(new Milk(100, Milk.Type.SEMI));
        latte2.addIngredient(new Water());
        latte2.addIngredient(new Coffee());

        assertNotEquals(latte, latte2);
    }

    @Test
    public void testRecipeMultipleIngredientsDifferentCoffeeType() throws Exception {

        Recipe latte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        latte.addIngredient(new Coffee());
        latte.addIngredient(new Water());
        latte.addIngredient(new Milk(100, Milk.Type.WHOLE));

        Recipe latte2 = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        latte2.addIngredient(new Milk(100, Milk.Type.WHOLE));
        latte2.addIngredient(new Water());
        latte2.addIngredient(new Coffee( 8, true)); // 8 is default amount; default decaf=false

        assertNotEquals(latte, latte2);
    }

    @Test
    public void testRecipeMultipleIngredientsDifferentAmmounts() throws Exception {

        Recipe latte = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        latte.addIngredient(new Coffee());
        latte.addIngredient(new Water());
        latte.addIngredient(new Milk(100, Milk.Type.WHOLE));

        Recipe latte2 = new Recipe("Large Soy Latte", 2.5, Recipe.Size.LARGE, 3);
        latte2.addIngredient(new Milk(101, Milk.Type.WHOLE));
        latte2.addIngredient(new Water());
        latte2.addIngredient(new Coffee());

        assertNotEquals(latte, latte2);
    }
}
