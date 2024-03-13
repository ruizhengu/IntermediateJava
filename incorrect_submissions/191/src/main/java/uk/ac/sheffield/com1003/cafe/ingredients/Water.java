package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(8);
    }
    
    //overloaded constructor
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
    public boolean equals(Object anotherWater) {
    	//checks whether it is an instance of Water then casts it
    	if(anotherWater instanceof Water) {
    	  Water water = (Water)anotherWater;
    	  //compares name, unit and amount
    	  if(this.getName().equals(water.getName()) &&
    			  this.getUnit() == water.getUnit() && this.getAmount() == water.getAmount()) {
    		  return true;
    	  }
    	}
    	return false;
    }

    


}
