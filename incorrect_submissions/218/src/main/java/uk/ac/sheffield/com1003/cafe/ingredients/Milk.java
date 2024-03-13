package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * An enumeration of Milk types - Whole, Semi, Skimmed and Soy.
 */
public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;
/**
 * This creates a default Milk constructor with default values of 100ml and Whole milk.
 */
    public Milk() {
        this(100, Type.WHOLE);
    }
/**
 * Creates a Milk object with the specified amount and default type of Whole milk
 * @param amount the amount of milk in ml.
 */
    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }
/**
 * Creates a Milk object with the specified amount and type.
 * @param amount the amount of milk in ml.
 * @param type the type of milk.
 */
    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }
/**
 * Returns a string of the Milk object outlining it's information.
 * @return a string of the Milk object outlining it's information.
 */
    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
