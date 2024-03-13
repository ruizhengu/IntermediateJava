package uk.ac.sheffield.com1003.cafe.ingredients;

/** Represents the Syrup ingredient */

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Strawberry");
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = flavour;
        this.amount = 15;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + this.unit + ", amount=" + this.amount +
            ", flavour=" + this.flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        // Not the same ingredient immediately, if another is null or not the same class.
        if (another == null || ! (another instanceof Syrup)) {
            return false;
        }

        // By here, another is confirmed to be of the same ingredient type, check if IVs same.
        if ((this.name.equals(((Syrup)another).getName())) &&
                (this.amount == ((Syrup)another).getAmount()) &&
                (this.unit == ((Syrup)another).getUnit()) &&
                (this.flavour.equals(((Syrup)another).flavour))) {
            // All instance variables match, return true.
            return true;
        } else {
            // One instance variable doesn't match - return false; not equals.
            return false;
        }
    }

}
