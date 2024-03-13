package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

	private String flavour;
	
	public Syrup() {
        this.name = "Syrup";
        this.amount = 5;
        this.unit = Unit.ML;
        this.flavour = "Pumpkin Spice";
    }

    @Override
    public String toString() {
        return "Syrup [unit= " + unit +" amount= " + amount +" flavour= "+ flavour + "]";
        
    }
}
