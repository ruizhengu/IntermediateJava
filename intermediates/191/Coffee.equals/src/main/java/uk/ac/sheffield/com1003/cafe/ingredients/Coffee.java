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
    public boolean equals(Object anotherCoffee) {
    	//checks whether it is an instance of coffee then casts it
    	if(anotherCoffee instanceof Coffee) {
    	  Coffee coffee = (Coffee)anotherCoffee;
    	  //compares name, unit, decaf and amount
    	  if((this.decaf == coffee.decaf) && this.getName().equals(coffee.getName()) &&
    			  this.getUnit() == coffee.getUnit() && this.getAmount() == coffee.getAmount()) {
    		  return true;
    	  }
    	}
    	return false;
    }
    
}
