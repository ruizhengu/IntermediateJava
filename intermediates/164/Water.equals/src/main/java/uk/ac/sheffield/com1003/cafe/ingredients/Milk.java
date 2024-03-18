package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This class is used to instantiate Milk objects.
 * As well as the inherited name, unit and amount, milk objects have the attribute type
 * It also overrides toString and equals methods to make them more specific to Milk objects
 */
public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    /**
     * Default constructor for Milk
     */
    public Milk() {
        this(100, Type.WHOLE);
    }

    /**
     * Another constructor for Milk taking the amount as an input
     * @param amount the volume of milk in millilitres
     */
    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    /**
     * Another constructor for Milk taking the amount and type of milk as inputs
     * @param amount the volume of milk in millilitres
     * @param type the type of milk (e.g WHOLE, SOY)
     */
    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }

    public Type getType() { return type; }

    /**
     * Compares another object with this Milk type object and returns whether they are the same
     * Overrides the equals method in the parent class
     *
     * @param another a pointer to the object that this object is being compared to
     * @return true if they are considered equal, false otherwise
     */

    @Override
    public boolean equals(Object another){
        if (!(another instanceof Milk)) {
            return false;
        }
        else {
            // Cast "another" to a Milk object so that we can call getType() on it
            Milk otherIngredient = (Milk)another;
            return (this.name.equals(otherIngredient.getName()) &&
                    this.amount == otherIngredient.getAmount() &&
                    this.unit == otherIngredient.getUnit() &&
                    this.type == otherIngredient.getType());
        }
    }

    /**
     * A toString method overriding the one in the Ingredient superclass
     * @return a clear display of the relevant instance variables for this Milk object
     */
    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
