package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {

    /**
     * Enum to represent the type of milk
     */
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
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj The reference object with which to compare.
     *
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        // Check if the object is null or not an instance of Milk
        if (obj == null || !(obj instanceof Milk)) {
            return false;
        }

        // Cast the object to a Milk instance
        Milk another = (Milk) obj;

        // Check if the properties of the two Milk objects are equal
        if (unit != another.unit) {
            return false;
        }
        if (amount != another.amount) {
            return false;
        }
        if (type != another.type) {
            return false;
        }
        return name.equals(another.name);
    }
}
