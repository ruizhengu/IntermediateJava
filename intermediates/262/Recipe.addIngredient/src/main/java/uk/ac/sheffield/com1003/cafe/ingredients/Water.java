package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

	/**
     *initialises units to ML and amount to 30
     *and name to Water
     */
    public Water() {
        this(30);
    }
    
	/**
     *initialises units to ML and name to "Water"
     *and takes in an amount
     */
    public Water(int amount)	{
        this.amount = amount;
        this.name = "Water";
        this.unit = Unit.ML;
    }

	/**
     * boolean return true if two ingredients objects are Water
     * and are exactly the same
     * @return true if two Water are the identical
     */
    public boolean equals(Ingredient another)	{
    	if (! (another instanceof Water)) //if both Water, then names are equal
            return false;
    	
    	if (this.amount == another.getAmount() && this.unit == another.getUnit()) {
    		return true;
    	}
    	
    	return false;
    }
    
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
