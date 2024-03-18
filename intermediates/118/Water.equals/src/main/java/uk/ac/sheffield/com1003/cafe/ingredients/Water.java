package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
    	this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }
    
    public Water(int amount) {
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
    
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        return (name.equals(((Water)another).getName()) && (unit == ((Water) another).getUnit())
        		&& (amount == ((Water)another).getAmount()));
    }
    
}
