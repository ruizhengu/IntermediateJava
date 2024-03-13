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
    
    public Coffee(int amount) {
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
    
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        return (name.equals(((Coffee)another).getName()) && (unit == ((Coffee) another).getUnit())
        		&& (amount == ((Coffee)another).getAmount()) && (decaf == ((Coffee)another).decaf));
    }
    
}
