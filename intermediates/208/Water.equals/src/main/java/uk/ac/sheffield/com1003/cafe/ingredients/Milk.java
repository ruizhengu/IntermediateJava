package uk.ac.sheffield.com1003.cafe.ingredients;
/**
 * This class represents milk.
 * It is a subclass of the Ingredient class.
 * It has attributes for its name, unit, amount and type.
 */
public class Milk extends Ingredient {
    public enum Type {
        WHOLE, SEMI, SKIMMED, SOY
    };

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

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Milk)) {
            return false;
        }
        Milk anotherMilk = (Milk) another;
        if (!name.equals(anotherMilk.name)) {
            return false;
        }
        if (amount != anotherMilk.amount) {
            return false;
        }
        if (type != anotherMilk.type) {
            return false;
        }
        return true;
    }

}
