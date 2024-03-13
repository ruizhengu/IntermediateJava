package uk.ac.sheffield.com1003.cafe.ingredients;

import uk.ac.sheffield.com1003.cafe.Recipe;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8, false);
    }

    public Coffee(int amount) {
        this(amount, false);
    }

    /**
     * Constructor that takes the amount and caffeination as
     * parameters and initialises unit to Unit.GR.
     *
     * @param amount The quantity of coffee in grams.
     * @param decaf Whether the coffee is decaf or not.
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof Coffee) {
            Coffee otherCoffee = (Coffee) other;
            if (super.equals(other)) {
                if (
                    this.amount == otherCoffee.amount &&
                    this.decaf == otherCoffee.decaf &&
                    this.unit == otherCoffee.unit) {
                    return true;
                }
            }
        }
        return false;
    }
}
