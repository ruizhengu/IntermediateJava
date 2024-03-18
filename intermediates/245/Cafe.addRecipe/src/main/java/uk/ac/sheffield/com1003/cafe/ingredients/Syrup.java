package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
	private String flavour;
	
	public Syrup() {
		this("Caramel");
	}
	
	public Syrup(String flavour) {
		this.name = "Syrup";
		this.flavour = flavour;
		this.unit = Unit.ML;
		this.amount = 5;
	}
	
	@Override
	public String toString() {
		return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
	}
}
