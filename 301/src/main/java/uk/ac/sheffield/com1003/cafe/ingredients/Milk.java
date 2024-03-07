package uk.ac.sheffield.com1003.cafe.ingredients;

/** Represents the Milk ingredient */

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Milk() {
        this(100, Type.WHOLE);
    }

    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object another) {
        // Not the same ingredient immediately, if another is null or not the same class.
        if (another == null || ! (another instanceof Milk)) {
            return false;
        }

        // By here, another is confirmed to be of the same ingredient type, check if IVs same.
        if ((this.name.equals(((Milk)another).getName())) &&
                (this.amount == ((Milk)another).getAmount()) &&
                (this.unit == ((Milk)another).getUnit()) &&
                (this.type == ((Milk)another).type)) {
            // All instance variables match, return true.
            return true;
        } else {
            // One instance variable doesn't match - return false; not equals.
            return false;
        }
    }

}
