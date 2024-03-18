package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8);
    }
    
    public Coffee(int amount) {
    	this(amount, false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    
    public boolean compare(Coffee coffee) {
    	if (super.compare(coffee))
    		if (this.decaf == coffee.decaf)
    			return true;
    	return false;
    }
}
