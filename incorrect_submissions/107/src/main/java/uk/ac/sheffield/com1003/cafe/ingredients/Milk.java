/**
 * Milk.java
 *
 * @version 1.0 15/03/2023
 *
 * @author Naseem Hoque
 */

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

    /**
     * Overrides equals() method to compare instance variables of the Milk.java class
     *
     * @param another Ingredient to be compared to
     * @return True is the ingredients are identical; returns false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Milk))
            return false;
        return super.equals(another) && amount == ((Milk)another).amount  && type == ((Milk)another).type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
