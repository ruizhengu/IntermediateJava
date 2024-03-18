package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
	private String flavour;
	
	public Syrup() {
		this("vanilla");
	}
	public Syrup(String flavour) {
		this.name = "Syrup";
		this.unit = Unit.ML;
		this.amount = 30;
		this.flavour = flavour;
	}
	
	public String toString() {
		return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
	}
}
