package uk.ac.sheffield.com1003.cafe.ingredients;
/**
 * The Milk class represents a type of milk used in drinks. It can be measured in milliliters and
 * can be whole, semi-skimmed, skimmed, or soy.
 */
public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    /**
     * Constructs a new Milk object with a default amount of 100 milliliters and whole milk type.
     */
    public Milk() {
        this(100, Type.WHOLE);
    }

    /**
     * Constructs a new Milk object with the specified amount and whole milk type.
     *
     * @param amount the amount of milk, in milliliters
     */
    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    /**
     * Constructs a new Milk object with the specified amount and type.
     *
     * @param amount the amount of milk, in milliliters
     * @param type the type of milk
     */
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
        if (! (another instanceof Milk)) {
            return false;
        }

        Milk otherMilk = (Milk) another;
        return this.name.equals(otherMilk.name) && this.unit.equals(otherMilk.unit)
                && this.amount == otherMilk.amount && this.type.equals(otherMilk.type);
    }

    public boolean equalsSolution(Object another) {
        if (! (another instanceof Milk)) {
            return false;
        }

        Milk otherMilk = (Milk) another;
        return this.name.equals(otherMilk.name) && this.unit.equals(otherMilk.unit)
                && this.amount == otherMilk.amount && this.type.equals(otherMilk.type);
    }
}
