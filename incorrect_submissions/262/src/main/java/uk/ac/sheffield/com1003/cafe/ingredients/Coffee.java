package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

	
	/**
     * Constructor which initialises amount to 8grams
     * and false decaf
     */
    public Coffee() {
        this(8, false);
    }
    
	/**
     * Constructor which takes in amount
     * and initialises false decaf
     */
    public Coffee(int amount)	{
    	this(amount, false);
    }

	/**
     * Constructor which takes amount
     * and boolean decaf and initialises unit and name
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    
	/**
     * boolean returning false if not decaf
     * @return false if not decaf 
     */
    public boolean isDecaf()	{
    	return decaf;
    }
    
	/**
     * boolean return true if two ingredients objects are Coffee
     * and are exactly the same
     * @return true if two Coffees are the identical
     */
    public boolean equals(Ingredient another)	{
    	if (! (another instanceof Coffee)) //if both Coffee, then names are equal
            return false;
    	
    	if (this.amount == another.getAmount() && this.unit == another.getUnit() &&
    				this.decaf == ((Coffee)another).isDecaf())	{
    		return true;
    	}
    	
    	return false;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
