package uk.ac.sheffield.com1003.cafe.ingredients;

import java.lang.reflect.Constructor;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8, false);
    }

    public Coffee(int amount) {
        this(amount, false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public boolean equals(Object other) {
        // This method redirects .equals() of Ingredient Array elements to the correct method.
        if (other instanceof Coffee)
            return equals((Coffee)other);
        else
            return false;
    }

    public boolean equals(Coffee other) {
        return name == other.name
                && amount == other.amount
                && unit == other.unit
                && decaf == other.decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
