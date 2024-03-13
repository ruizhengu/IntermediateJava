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

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof Milk) {
            Milk otherMilk = (Milk) other;
            if (super.equals(other)) {
                if (
                    this.amount == otherMilk.amount &&
                    this.type == otherMilk.type &&
                    this.unit == otherMilk.unit) {
                    return true;
                }
            }
        }
        return false;
    }
}
