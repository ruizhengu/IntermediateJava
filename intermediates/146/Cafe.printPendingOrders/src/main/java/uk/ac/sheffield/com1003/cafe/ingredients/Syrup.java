package uk.ac.sheffield.com1003.cafe.ingredients;

import uk.ac.sheffield.com1003.cafe.ingredients.Milk.Type;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this(10, "Caramel");
    }
    
    public Syrup(String flavour) {
    	this(10, flavour);
    }
    

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }
    
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
    
    @Override
    public boolean equals(Object other) {
    	//basic object properties
    	if (!super.equals(other))
    		return false;
    	
    	//milk properties
    	Syrup syr = null;
    	if (!(other instanceof Milk))
            return false;
    	else
    		syr = (Syrup)other;
    	
    	if (this.flavour != syr.flavour)
    		return false;
    	
    	return true;
    }
}
