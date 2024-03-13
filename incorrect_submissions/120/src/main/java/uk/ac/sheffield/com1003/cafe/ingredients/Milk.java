package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * The Milk class extends the Ingredient class to provide
 * extra functionality by using a milk type enum.
 *
 * @author Yusuf Ibn Saifullah
 * @since 12-03-2023
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
    public boolean equals(Object o2) {
        if (o2.getClass() != Milk.class) {
            return false;
        }
        Milk m2 = (Milk) o2;
        // compares all the parameters of milk
        if (this.amount == m2.amount && this.name == m2.name && this.unit == m2.unit && this.type == m2.type)
            return true;
        else
            return false;
    }
}
