/**

Represents a syrup ingredient that can be added to a drink.
Syrup extends the Ingredient class and contains a private field named flavour.
The class provides two constructors, one with a flavour argument and a default constructor that sets flavour to "Hazelnut".
The toString method is overridden to return a string representation of the syrup.
*/
package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
	private String flavour;
	
	public Syrup(String flavour) {
	     this.unit = Unit.ML;
	     this.flavour = flavour;
	}
	
	// Default constructor
	public Syrup() {
		this.flavour= "Hazelnut";
		this.unit= Unit.ML;
		this.amount= 15;
	}
	
	 public String getFlavour() {
	        return flavour;
	    }
	 
	 // Override toString method to return a string representation of the syrup
	 @Override
	    public String toString() {
	        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
	    }
}
