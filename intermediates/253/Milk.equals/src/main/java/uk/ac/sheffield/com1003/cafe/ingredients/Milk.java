package uk.ac.sheffield.com1003.cafe.ingredients;

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
    public boolean equals(Object other) {
        // This method redirects .equals() of Ingredient Array elements to the correct method.
        if (other instanceof Milk)
            return equals((Milk)other);
        else
            return false;
    }

    public boolean equals(Milk other) {
        return name == other.name
                && unit == other.unit
                && amount == other.amount
                && type == other.type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
