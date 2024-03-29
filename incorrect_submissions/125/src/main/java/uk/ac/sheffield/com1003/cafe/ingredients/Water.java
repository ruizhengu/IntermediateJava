package uk.ac.sheffield.com1003.cafe.ingredients;

import uk.ac.sheffield.com1003.cafe.Recipe;

import java.time.LocalDateTime;

public class Water extends Ingredient {

    /**
     * Constructor that initialises unit to Unit.ML,
     * and amount to 30.
     */
    public Water() {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = 30;
    }

    /**
     * Constructor that takes the amount as a parameter,
     * initialising the unit to Unit.ML.
     *
     * @param amount Quantity of water in ML.
     */
    public Water(int amount) {
        this();
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof Water) {
            Water otherWater = (Water) other;
            if (super.equals(other)) {
                if (
                    this.amount == otherWater.amount &&
                    this.unit == otherWater.unit) {
                    return true;
                }
            }
        }
        return false;
    }
}
