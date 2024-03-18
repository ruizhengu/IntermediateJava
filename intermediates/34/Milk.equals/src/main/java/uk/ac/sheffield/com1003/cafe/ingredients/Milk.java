package uk.ac.sheffield.com1003.cafe.ingredients;

public class Milk extends Ingredient {
    public enum Type { WHOLE, SEMI, SKIMMED, SOY };
    private Type type = Type.WHOLE;

    public Milk() {
        this(100, Type.WHOLE);
    }

    public Milk(int amount) {
        this(amount, Type.WHOLE);
    }

    public Milk(int amount, Type type) {
        this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
        this.type = type;
    }
    
    public Type getType() {
    	return type;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
    
    @Override
    public boolean equals(Object another) {
    	// Checks if each instance variable of the object is equal
    	if (this.getAmount() == ((Ingredient) another).getAmount()) {
    		if(this.getUnit() == ((Ingredient) another).getUnit()) {
    			if(this.getType() == ((Milk) another).getType()) {
    				return true;
    			}
    		}
    	}
        
    	return false;
    }
}
