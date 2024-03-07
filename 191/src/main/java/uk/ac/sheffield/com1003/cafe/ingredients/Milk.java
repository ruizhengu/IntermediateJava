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
    public boolean equals(Object anotherMilk) {
    	//checks if it is an instance of milk and casts it
    	if(anotherMilk instanceof Milk) {
    		Milk milk = (Milk)anotherMilk;
    		//compares the milk type, amount, unit and name
    		if((this.type == milk.type) && (this.amount == milk.amount) && (this.name == milk.getName()) &&
    				(this.unit == milk.getUnit())) {
    			return true;
    		}
    	}
    	return false;
    }
    
}
