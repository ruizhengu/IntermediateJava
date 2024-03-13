package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY }
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
    public boolean equals(Object another) {
        // Task 5 - Guard clause to check if same object type since.
        // Using getClass over instanceof for same reason as for recipe, no subclasses.
        if (another == null || another.getClass() != Milk.class) {
            return false;
        }

        Milk other = (Milk) another;
        if (!name.equals(other.name)
            || unit != other.unit
            || amount != other.amount
            || type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
