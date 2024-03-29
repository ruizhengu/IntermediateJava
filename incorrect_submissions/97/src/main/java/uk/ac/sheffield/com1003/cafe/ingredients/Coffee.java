package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }
    
    //Overloading the Coffee constructor
    public Coffee(int amount) {
	}

	@Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
	
	@Override
	 public boolean equals(Object another) {
		 if (another == null || ! (another instanceof Coffee))
			 return false;
		 
		 Coffee coffeeObj = (Coffee) another;
		 return (name.equals(coffeeObj.getName()) && amount == coffeeObj.getAmount()
				 && unit == coffeeObj.getUnit() && decaf == coffeeObj.decaf);
	}
}
