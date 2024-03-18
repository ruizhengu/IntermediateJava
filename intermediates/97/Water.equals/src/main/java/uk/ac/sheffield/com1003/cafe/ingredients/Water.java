package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
    	this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
        
    }
    
    //Overloading the water constructor 
    public Water(int amount) {
		
	}

	@Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
	
	 @Override
	 public boolean equals(Object another) {
		 if (another == null || ! (another instanceof Water))
			 return false;
		 
		 Water waterObj = (Water) another;
		 return (name.equals(waterObj.getName()) && amount == waterObj.getAmount()
				 && unit == waterObj.getUnit());
	}
}
