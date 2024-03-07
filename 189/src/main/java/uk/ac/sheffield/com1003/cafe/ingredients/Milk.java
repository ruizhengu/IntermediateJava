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

    /* Method to return true if two milk objects are the same */
    @Override
    public boolean equals(Object another) {
        if (another == null || getClass() != another.getClass())
            return false;
        /* If the class is the same, each  specific attribute is compared */
        Milk anotherMilk = (Milk) another;
        if (this.getName() == anotherMilk.getName()) {
            if (this.getAmount() == anotherMilk.getAmount()) {
                if (this.getUnit() == anotherMilk.getUnit()) {
                    if (this.type == anotherMilk.type) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
