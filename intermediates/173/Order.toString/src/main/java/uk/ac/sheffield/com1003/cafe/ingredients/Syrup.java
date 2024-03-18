package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * Creating a new class for an extra ingredient(Chocolate syrup) 
 * */
public class Syrup extends Ingredient{

	private String flavour; 
	
	public Syrup(String flavour) {
		
		this.flavour = flavour;
		
	}
	
	public Syrup() {
		
		this.unit = Unit.ML;
		this.amount = 1;
		this.flavour = "Chocolate"; 
		
	} 
	
	@Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
	
	
}
