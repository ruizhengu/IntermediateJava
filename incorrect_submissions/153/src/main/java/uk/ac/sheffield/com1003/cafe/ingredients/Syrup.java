package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
	private String flavour;
	
	public Syrup(String flavour, Unit unit, int amount) {
		this.flavour = flavour;
		this.unit = unit;
		this.amount = amount;
	}
	
	public Syrup() {
		this.flavour = "Vanilla";
		this.unit = Unit.ML;
		this.amount = 0;
	}
	
	@Override
	public String toString() {
		return "Water [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
	}
	
}
