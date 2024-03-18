package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    /**
     * constructor that initialises amount as 100, type as whole,
     * unit as ML and name as 'Milk'
     */
    public Milk() {
        this(100, Type.WHOLE);
    }

    /**
     * constructor that initialises amount as the parameters, type as whole,
     * unit as ML and name as 'Milk'
     * 
     * @param amount the user's desired amount
     */
    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    /**
     * constructor that initialises amount and type as the parameters,
     * unit as ML and name as 'Milk'
     * 
     * @param amount the user's desired amount
     * @param type the user's desires type
     */
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
}
