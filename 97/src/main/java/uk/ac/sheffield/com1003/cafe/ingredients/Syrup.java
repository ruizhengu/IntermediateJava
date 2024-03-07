package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
	private String flavour;
	
	public Syrup() {
        this.unit = Unit.ML;
        this.amount = 20;
        this.flavour = "Vanilla";
	}
	
	public Syrup(String flavour) {
    }
	
	//Getter Method 
	 public String getFlavour() {
	        return this.flavour;
	 }
	 
	 
	@Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
	
	@Override
	 public boolean equals(Object another) {
		 if (another == null || ! (another instanceof Syrup))
			 return false;
		 
		 Syrup syrupObj = (Syrup) another;
		 return (amount == syrupObj.getAmount() && unit == syrupObj.getUnit() && 
				 flavour.equals(syrupObj.getFlavour()));
	}

}