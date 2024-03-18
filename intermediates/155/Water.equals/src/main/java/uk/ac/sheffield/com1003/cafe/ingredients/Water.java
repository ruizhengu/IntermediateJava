package uk.ac.sheffield.com1003.cafe.ingredients;

/** Represents the Water ingredient */

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water(int amount) {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object another) {
        // Not the same ingredient immediately, if another is null or not the same class.
        if (another == null || ! (another instanceof Water)) {
            return false;
        }

        // By here, another is confirmed to be of the same ingredient type, check if IVs same.
        if ((this.name.equals(((Water)another).getName())) &&
                (this.amount == ((Water)another).getAmount()) &&
                (this.unit == ((Water)another).getUnit())) {
            // All instance variables match, return true.
            return true;
        } else {
            // One instance variable doesn't match - return false; not equals.
            return false;
        }
    }
}
