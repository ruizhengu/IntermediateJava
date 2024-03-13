package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This is a child class of the abstract class ingredient used for the
 * milk ingredient
 */

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    /**
     * Constructor that initialises ingredient amount to 100 and
     * milk type to WHOLE.
     */
    public Milk() {
        this(100, Type.WHOLE);
    }

    /**
     * Constructor that takes ingredient amount as parameter, 
     * and initialises milk type to WHOLE.
     */
    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    /**
     * Constructor that takes ingredient amount and milk type as parameter, 
     * and initialises ingredient name to "Milk" and unit to ML.
     */
    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }

    /**
     * @return Returns a string representation of the milk in
     * the format "Milk [unit=<unit>, amount=<amount>, type=<type>]"
     */
    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + 
                "]";
    }
}
