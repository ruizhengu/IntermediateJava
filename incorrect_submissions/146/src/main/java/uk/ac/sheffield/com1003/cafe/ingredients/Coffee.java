package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8, false);
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

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
    
    @Override
    public boolean equals(Object other) {
    	//basic object properties
    	if (!super.equals(other))
    		return false;
    	
    	//coffee properties
    	Coffee cof = null;
    	if (!(other instanceof Coffee))
            return false;
    	else
    		cof = (Coffee)other;
    	
    	if (this.decaf != cof.decaf)
    		return false;
    	
    	return true;
    }
}
