package uk.ac.sheffield.com1003.cafe.ingredients;


public class Syrup extends Ingredient {
	
	private String flavor;

    public Syrup() {
    	this.flavor = "Sweet";
    	this.unit = Unit.ML;
    	this.amount = 5;
    }
    
    public Syrup(String flavor) {
    	this.flavor = flavor;
    	this.unit = Unit.ML;
    	this.amount = 5;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavor=" + flavor + "]";
    }

}
