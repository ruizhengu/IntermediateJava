package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
	private String flavour;
	
	public Syrup(String flavour) {
		this.flavour = flavour;
		unit = Unit.ML;
		amount = 50;
	}
	
	public Syrup() {
		unit = Unit.ML;
		amount = 50;
		flavour = "vanilla";
	}
	
	@Override
	public String toString() {
		return "Syrup [unit="+unit+", amount="+amount+", flavour="+flavour+"]";
	}

}
