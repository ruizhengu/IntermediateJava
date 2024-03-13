/**
 * Syrup.java
 * Represents a syrup ingredient with a specified or default flavour, amount, and unit of measurement.
 * @version 1.0 10/03/2023
 * @author Unknown
 */

package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;
    private Unit unit;
    private int amount;

    public Syrup(String flavour) {
        super();
        this.flavour = flavour;
    }

    public Syrup(String flavour, int amount) {
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = amount;
    }

    public Syrup() {
        super();
        this.flavour = "Hazelnut";
        this.amount = 25;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
