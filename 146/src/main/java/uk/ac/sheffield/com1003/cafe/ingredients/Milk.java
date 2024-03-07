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

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", type=" + type + "]";
    }
    
    @Override
    public boolean equals(Object other) {
    	//basic object properties
    	if (!super.equals(other))
    		return false;
    	
    	//milk properties
    	Milk mlk = null;
    	if (!(other instanceof Milk))
            return false;
    	else
    		mlk = (Milk)other;
    	
    	if (this.type != mlk.type)
    		return false;
    	
    	return true;
    }
}
