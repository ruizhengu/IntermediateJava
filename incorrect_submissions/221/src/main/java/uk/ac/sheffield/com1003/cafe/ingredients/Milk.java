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

    public boolean equals(Object another) {
        if (super.equals(another) && another instanceof Milk) {
            Milk otherIngredient = (Milk) another;
            return (unit.equals(otherIngredient.unit)
                    && amount == otherIngredient.amount
                    && type.equals(otherIngredient.type));
        }
        return false;
    }
    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
