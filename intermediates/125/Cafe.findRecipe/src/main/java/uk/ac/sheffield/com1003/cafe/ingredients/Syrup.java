package uk.ac.sheffield.com1003.cafe.ingredients;

import uk.ac.sheffield.com1003.cafe.Recipe;

/** Represents the ingredient syrup.
 * @author Samuel Taseff
 */
public class Syrup extends Ingredient {
    private String flavour;

    /**
     * Constructor that initialises the flavour
     * to ML, the amount to 100 ML, and the flavour to
     * Maple.
     */
    public Syrup(){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 100;
        this.flavour = "Maple";
    }

    /**
     * Constructor that takes the flavour as a
     * parameter and initialises unit to ML,
     * and the amount to 100.
     *
     * @param flavour a string representing the flavouring of the syrup
     */
    public Syrup(String flavour) {
        this();
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof Syrup) {
            Syrup otherSyrup = (Syrup) other;
            if (super.equals(other)) {
                if (
                    this.amount == otherSyrup.amount &&
                    this.flavour == otherSyrup.flavour &&
                    this.unit == otherSyrup.unit) {
                    return true;
                }
            }
        }
        return false;
    }
}