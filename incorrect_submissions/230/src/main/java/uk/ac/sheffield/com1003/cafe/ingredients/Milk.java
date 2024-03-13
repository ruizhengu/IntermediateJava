package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    /**
     * Constructor that initialises amount to 100 and type to whole.
     */
    public Milk() {
        this(100, Type.WHOLE);
    }

    /**
     * Constructor that takes amount as a parameter and sets type to whole.
     */
    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    /**
     * Constructor that takes the amount and type as parameters.
     */
    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }
    /**
     * Method that returns all the instance information in a string.
     */
    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
