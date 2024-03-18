package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
	//instance variable
    private boolean decaf;

    //constructor
    public Coffee() {
        this(8,false);
    }
    
    //overloaded constructor
    public Coffee(int amount) {
    	this(amount,false);
  
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
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        Coffee coffee = (Coffee) another;
        return name.equals(coffee.getName()) && amount == coffee.amount && unit == coffee.unit && decaf == coffee.decaf;
    }
    
}
