package uk.ac.sheffield.com1003.cafe.ingredients;

/** Represents the Coffee Ingredient */

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8,false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public Coffee(int amount) {
        this(amount, false);
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        // Not the same ingredient immediately, if another is null or not the same class.
        if (another == null || ! (another instanceof Coffee)) {
            return false;
        }

        // By here, another is confirmed to be of the same ingredient type, check if IVs same.
        if ((this.name.equals(((Coffee)another).getName())) &&
                (this.amount == ((Coffee)another).getAmount()) &&
                (this.unit == ((Coffee)another).getUnit()) &&
                (this.decaf == ((Coffee)another).decaf)) {
            // All instance variables match, return true.
            return true;
        } else {
            // One instance variable doesn't match - return false; not equals.
            return false;
        }
    }
}
