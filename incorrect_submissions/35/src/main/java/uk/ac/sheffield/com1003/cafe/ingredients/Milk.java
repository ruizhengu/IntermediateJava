package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type {
        WHOLE, SEMI, SKIMMED, SOY
    };

    private Type type = Type.WHOLE;

    public Milk() {
        this(100);
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
        if (this == another) {
            return true;
        }
        if (another == null) {
            return false;
        }

        if (another instanceof Milk) {
            Milk otherMilk = (Milk) another;
            if (name == otherMilk.getName()
                    && amount == otherMilk.getAmount()
                    && unit == otherMilk.getUnit()
                    && type == otherMilk.type) {
                return true;

            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
