package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
	private String flavour;
	
    public Syrup() {
        this.unit= Unit.ML;
        this.amount = 20;
        this.flavour= "Strawberry";
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount +", flavour=" + flavour + "]";
    }

}
