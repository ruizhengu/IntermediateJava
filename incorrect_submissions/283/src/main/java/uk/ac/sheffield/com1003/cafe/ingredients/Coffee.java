package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8, false);
    }

    public Coffee(int amount) {
        this(amount, false);
    }

    /**
     * Constructor that takes as parameters the amount
     * of coffee and whether the coffee is decaf or not.
     * 
     * @param amount Amount of coffee
     * @param decaf Whether the coffee is decaf
     */
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

    @Override
    public boolean equals(Object another) {
        if (!super.equals(another)) return false;
        
        // Check the Ingredients are the same type
        if (!(another instanceof Coffee))
            return false;
        
        // Test each attribute to see if they match
        Coffee coffee2 = (Coffee)another;
        return (amount == coffee2.amount && unit == coffee2.unit && decaf == coffee2.decaf);
    }
}
