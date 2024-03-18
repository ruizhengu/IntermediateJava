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

    public Type getType() { return this.type; }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }

    /**
     * Overrides the equals method in ingredient
     *
     * @param another The object to compare this too
     *
     * @return True if the name of this object is equal to the name of the another object, if the unit of this object
     * is equal to the unit of the another object, if the amount of this object is equal to the amount of the another
     * object and if the type of this object is equal to the type of the another object.
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Milk))
            return false;
        Milk m = (Milk) another;
        return name.equals(m.name) && amount == m.amount && unit == m.unit && type == m.type;
    }
}
