package uk.ac.sheffield.com1003.cafe.ingredients;

//ingredient class very similar to others; has a few constructors and a toString() method
public class Syrup extends Ingredient{
	
	private String flavour;
	
	public Syrup() {
		this.amount = 10;
		this.unit = Unit.ML;
		this.flavour = "Caramel";
	}
	
	public Syrup(String flavour) {
		this.amount = 10;
		this.unit = Unit.ML;
		this.flavour = flavour;
	}
	
	public Syrup(String flavour, int amount) {
		this.amount = amount;
		this.unit = Unit.ML;
		this.flavour = flavour;
	}
	
	public Syrup(String flavour, int amount, Unit unit) {
		this.amount = amount;
		this.unit = unit;
		this.flavour = flavour;
	}
	
	public String getFlavour() {
		return flavour;
	}
	
	public String toString() {
		return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + getFlavour() + "]";
	}
	
}
