/**
 * Syrup - subclass of Ingredient - Task 6
 */

package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    /**
     * Default constructor
     * Assigns a default value to the flavour, amount and unit instance variables
     */
    public Syrup() {
        this.flavour = "Chocolate";
        this.amount = 3;
        this.unit = Unit.ML;
    }

    /**
     * Constructor taking the String flavour as an argument
     * @param flavour
     */
    public Syrup(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
