package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this(10, "Vanilla"); /**I have no clue if this is a normal flavour used in coffee syrup.*/
    }
    
    public Syrup(int amount) {
    	this(amount, "Vanilla");
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
    
    @Override
    public boolean equals(Object another) {
    	if (super.equals(another) && (another instanceof Syrup) && (this.flavour == ((Syrup)another).flavour)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
