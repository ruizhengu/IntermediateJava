package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8,false);
    }
    
    public Coffee(int amount) {
        this(amount, false);
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
    
    public boolean equals(Object objectTwo) {
        if ( objectTwo == this)
            return true;
        if ( objectTwo == null || this.getClass() != objectTwo.getClass() ) 
            return false;
        // convert object to coffee type and compare instance variables
        Coffee coffeeTwo = (Coffee)objectTwo;
        if (name.equals(coffeeTwo.name) && amount==coffeeTwo.amount && unit==coffeeTwo.unit && 
                decaf==coffeeTwo.decaf)
            return true;
        return false;
    }
}
