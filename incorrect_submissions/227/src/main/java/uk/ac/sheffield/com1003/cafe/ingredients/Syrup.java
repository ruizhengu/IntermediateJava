package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
	private String flavour;
	
	public Syrup() {
		this("Flavourless");
	}

	public Syrup(String flavour) {
		this.name = "Syrup";
		this.flavour = flavour;
		this.unit = Unit.ML;
		this.amount = 10;
	}
	
	public String toString() {
		return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
	}
	
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;

        Syrup other = (Syrup)another;
        return amount == other.amount 
        		&& unit == other.unit 
        		&& flavour.equals(other.flavour)
        		&& name == other.name;
    }
}
