package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
        this.name = "coffee";
        this.unit = Unit.GR;
        this.decaf  = false;
    }

    public Coffee(int amount){
        this.amount = amount;
        this.name = "coffee";
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public boolean getDecaf(){
        return this.decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    // Overriding equals method from superclass Ingredient (needed for task 5)
    @Override
    public boolean equals(Object another){
        if(another == null && ! (another instanceof Coffee)){
            return false;
        }
        else if ( another instanceof Coffee && ((Coffee)another).getDecaf() == this.getDecaf() &&((Ingredient)another).getAmount() == this.amount && ((Ingredient)another).getUnit() == this.unit){
            return true;
        }
        return false;
        
    }
}
