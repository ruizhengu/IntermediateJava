package uk.ac.sheffield.com1003.cafe.ingredients;

import uk.ac.sheffield.com1003.cafe.Recipe;

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

    /**
     * @return milk type
     */
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Milk))
            return false;

        Milk other = (Milk) another;

        if (other.getUnit() != getUnit()) {
            return false;
        }

        if (other.getAmount() != getAmount()) {
            return false;
        }

        if (other.getType() != getType()) {
            return false;
        }

        return true;
    }
}
