package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
	private String flavour;
	
	public Syrup() {
		//Default flavour of syrup is golden syrup
		flavour = "Golden";
		this.name = flavour + " Syrup";
		this.unit = Unit.GR;
		this.amount = 10;
		
	}
	public Syrup(String flavour) {
		this.flavour = flavour;
		this.name = flavour + " Syrup";
		this.unit = Unit.GR;
		this.amount = 10;
	}
	public Syrup(String flavour, int amount) {
		this.flavour = flavour;
		this.name = flavour + " Syrup";
		this.unit = Unit.GR;
		this.amount = amount;
	}
	
	 public String toString() {
	        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
	    }
}
