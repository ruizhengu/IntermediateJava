package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

	private String flavour;
	
	public Syrup() {
		this(20);
	}
	
	public Syrup(int amount) {
		this(20, "golden");
	}
	
	public Syrup(int amount, String flavour) {
		this.name = "Syrup";
		this.amount = amount;
		this.unit = Unit.ML;
	}
	
	
	@Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
