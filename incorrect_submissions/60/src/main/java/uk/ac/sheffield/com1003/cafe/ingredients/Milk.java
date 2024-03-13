package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;
    
    /**
     * Constructor that initialises amount to 100, and unit to WHOLE.
     */
    public Milk() {
        this(100, Type.WHOLE);
    }
    
    /**
     * Constructor that takes amount as parameter,
     * initialises type to WHOLE.
     */
    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }
    
    /**
     * Constructor that takes amount and type as parameters,
     * initialises name to Milk, and unit to ML.
     */
    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }
    
    /**
     * getter for type
     * @return milk type
     */
    public Type getType() {
    	return type;
    }
    
    /**
     * Checks whether two Milk instances are the same
     * @return true if both instances are identical
     */
    public boolean equals(Object another) {
    	if (another == null ||
    			! (another instanceof Ingredient) ||
    			! (amount == ((Ingredient)another).getAmount()) ||
    			! (type == ((Milk)another).getType()))
    		return false;
        return name.equals(((Ingredient)another).getName());
    }
    
    /**
     * @return a String explaining the particular Milk instance
     */
    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
