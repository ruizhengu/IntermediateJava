/**
 * Milk.java
 * The Milk class represents a type of ingredient that can be used in a cafe.
 * It extends the Ingredient class and has an additional property of type.
 * @version 1.0 10/03/2023
 * @author Unknown
 */

package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY};
    private Type type = Type.WHOLE;

    public Milk() {
        this(100, Type.WHOLE);
    }

    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    /**
     * Creates a Milk object with the specified amount and milk type.
     * @param amount the amount of milk in milliliters
     * @param type the type of milk (whole, semi, skimmed, soy)
     */
    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }

    /**
     * Returns a string representation of the Milk object, including its unit, amount, and type properties.
     * @return a string representation of the Milk object
     */
    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
