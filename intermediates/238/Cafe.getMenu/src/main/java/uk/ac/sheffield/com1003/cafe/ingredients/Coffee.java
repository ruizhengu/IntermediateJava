/**
 * Coffee.java
 * This class represents a type of ingredient, Coffee, which can be decaf or regular and its amount measured in grams.
 * @version 1.0 10/03/2023
 * @author Unknown
 */
package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
    }

    /**
     * Creates a new Coffee object with the specified amount and decaf status.
     *
     * @param amount the amount of coffee, in grams
     * @param decaf true if the coffee is decaffeinated, false otherwise
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    /**
     * Generates string representation of the Coffee object including the unit, amount, and decaf status.
     * @return a string representation of the Coffee object
     */
    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
