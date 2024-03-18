package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
    	this.name = "Water";
    	this.unit = Unit.ML;
        this.amount = 30;
    }
    
    public Water(int amount) {
    	this.name = "Water";
    	this.unit = Unit.ML;
    	this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
    
    @Override
    public boolean equals(Object another) {
    	// Checks if each instance variable of the object is equal
    	if (this.getAmount() == ((Ingredient) another).getAmount()) {
    		if(this.getUnit() == ((Ingredient) another).getUnit()) {
    				return true;
    			
    		}
    	}
        
    	return false;
    }
}
