package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
	
	private String flavour = "";
	
	/**
     * Constructor which takes flavour and initialises units
     * to ML, name to "Water and amount to 20
     */
	public Syrup(String flavour)	{
		this.unit = Unit.ML;
		this.amount = 20;
		this.flavour =flavour;
		this.name = "Syrup";
	}
	
	/**
     * Constructor which initialises units 
     * to ML and amount to 20 and flavour to "chocolate"
     */
	public Syrup()	{
		this("Chocolate");
	}
	
    /**
     * Getter for flavour of syrup
     * @return flavour of syrup
     */
	public String getFlavour()	{
		return flavour;
	}
	
	/**
     * boolean return true if two ingredients objects are Syrup
     * and are exactly the same
     * @return true if two Syrup are the identical
     */
    public boolean equals(Ingredient another)	{
    	if (! (another instanceof Syrup)) //if both Syrup, then names are equal
            return false;
    	
    	if (this.amount == another.getAmount() && this.unit == another.getUnit() &&
    			this.flavour.equals(((Syrup)another).getFlavour())) {
    		return true;
    	}
    	
    	return false;
    }
	
    @Override
	public String toString()	{
		return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
	}
}
