package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Type getType() { return this.type; }

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
    public boolean equals(Object other){
        // Handle edge cases
        if (!(other instanceof Milk))
            return false;
        if (this == other)
            return true;
        // Handle super equals
        boolean equals = super.equals(other);
        // Check instance variables
        Milk otherMilk = (Milk)other;
        return equals && (amount == otherMilk.getAmount())
                && (unit == otherMilk.getUnit())
                && (type == otherMilk.getType());
    }
}
