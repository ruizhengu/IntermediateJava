package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
	
	private String flavour;
	
	public Syrup(String flavour) {
		this.unit = unit.ML;
		this.amount = 50;
		this.flavour = flavour;
	}
	
	public Syrup() {
		this.unit = unit.ML;
		this.amount = 50;
		this.flavour = "chocolate";
	}
	
	public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
	
	public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;
        return (unit == ((Syrup)another).getUnit()) && (amount == ((Syrup)another).getAmount()) && (flavour == ((Syrup)another).flavour);
    }

}
