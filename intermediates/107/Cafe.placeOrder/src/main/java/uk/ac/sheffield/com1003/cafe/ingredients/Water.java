/**
 * Water.java
 *
 * @version 1.0 15/03/2023
 * @author Naseem Hoque
 */

package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
    }

    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    /**
     * Overrides equals() method to compare instance variables of the Water.java class
     *
     * @param another Ingredient to be compared to
     * @return True is the ingredients are identical; returns false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        Water w = (Water) another;
        return name.equals(w.name) && amount == w.amount && unit == w.unit;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
