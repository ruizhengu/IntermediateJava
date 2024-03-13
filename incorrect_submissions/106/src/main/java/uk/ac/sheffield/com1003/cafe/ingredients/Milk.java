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

    public Type getType() {
        return type;
    }

    /**
     * Two milks are equal if they have the same name, amount, unit and type
     * @param another the other milk to compare to
     * @return true if the two milks are equal, false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Milk)) {
            return false;
        }

        Milk anotherMilk = (Milk)another;
        if (anotherMilk.getName().equals(this.name) && anotherMilk.getAmount() == this.amount 
        && anotherMilk.getUnit() == this.unit && anotherMilk.getType() == this.type) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
