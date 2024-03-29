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
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    /**
     * Check if two objects are the same.
     * @param Object another to add a recipe to compare
     * @return True if another object is milk and all parameters are same
     */
    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Milk)) return false;
        Milk milk = (Milk) another;
        return name.equals(milk.getName()) &&
                unit.equals(milk.getUnit()) &&
                amount == milk.getAmount() &&
                type.equals(milk.type);
    }
}
