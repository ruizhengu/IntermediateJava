package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
	
	private String flavour;
	
    //no argument constructor
	public Syrup() {
		this("Vanilla");
	}
	
	public Syrup(String flavour) {
		this(flavour, 20);
	}

	public Syrup(String flavour, int amount) {
		this.unit = Unit.ML;
		this.flavour = flavour;
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Syrup [unit=" +unit+", amount="+amount+", flavour="+flavour+"]";
	}
	
	@Override
    public boolean equals(Object anotherSyrup) {
		//checks if it is an instance of syrup then casts it
    	if(anotherSyrup instanceof Syrup) {
    	  Syrup syrup = (Syrup)anotherSyrup;
    	  //compares the flavour, amount and unit
    	  if((this.flavour == syrup.flavour) && (this.amount == syrup.amount) && (this.unit == syrup.getUnit())) {
    		  return true;
    	  }
    	}
    	return false;
    }

	

}
