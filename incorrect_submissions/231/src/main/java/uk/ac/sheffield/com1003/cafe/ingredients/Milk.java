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
     * Compares two Milk objects to see if have equivalent data field values
     *
     * @param another Takes in another Milk instance as an input value
     * @return Returns true if the name, amount, unit and {@link Milk#type} are the same; return false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Milk))
            return false;
        return this.name.equals(((Milk)another).getName()) && this.amount == ((Milk)another).getAmount() &&
                this.unit.equals(((Milk)another).getUnit()) && this.type.equals(((Milk)another).type);
    }
}
