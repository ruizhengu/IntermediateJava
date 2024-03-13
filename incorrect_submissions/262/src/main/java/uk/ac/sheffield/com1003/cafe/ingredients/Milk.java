package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

	/**
     * Constructor which initialises amount to 100
     * and type to WHOLE
     */
    public Milk() {
        this(100, Type.WHOLE);
    }

	/**
     * Constructor which takes amount
     * and initialises type of milk to WHOLE
     */
    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

	/**
     * Constructor which takes amount
     * and type of milk, initialising 
     * units to ML and name to "Milk"
     */
    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }
    
    /**
     * Getter for type of milk
     * @return type of milk
     */
    public Type getType()	{
    	return type;
    }
    
	/**
     * boolean return true if two ingredients objects are Milk
     * and are exactly the same
     * @return true if two Milks are the identical
     */
    public boolean equals(Ingredient another)	{
    	if (! (another instanceof Milk)) //if both Milk, then names are equal
            return false;
    	
    	if (this.amount == another.getAmount() && this.unit == another.getUnit() &&
    				this.type == ((Milk)another).getType())	{
    		return true;
    	}
    	
    	return false;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
}
