package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
	
	private String flavour;
	
	public Syrup() {
		this("Vanilla", 15);
		
	}
	
	public Syrup(String flavour, int amount) {
		this.flavour = flavour;
		this.unit = Unit.ML;
		this.amount = amount;
	}
	
	public String toString() {
		return "Syrup [unit="+ unit + ", amount=" + amount + ", flavour=" + flavour + "]";
	}

}
