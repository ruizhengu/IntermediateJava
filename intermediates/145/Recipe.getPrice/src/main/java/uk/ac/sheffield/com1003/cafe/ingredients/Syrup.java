package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
	private String flavour;
	
	public Syrup(String syrup) {
		this.amount = 30;
		this.unit = Unit.ML;
		flavour = syrup;
	}
	 public Syrup(int amount, String syrup) {
	    this.amount = amount;
	    this.unit = Unit.ML;
	    flavour = syrup;
	 }
	 public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
