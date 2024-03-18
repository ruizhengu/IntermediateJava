package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {
    
    /**
     * Constructor that initialises water amount to 30.
     */
    public Water() {
        this(30);
    }
    
    /**
     * Constructor that takes amount as parameter,
     * initialises name to Water, and unit to ML.
     */
    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }
    
    /**
     * getter for amount
     * @return water amount
     */
    public int getAmount() {
        return amount;
    }
    
    /**
     * Checks whether two Water instances are the same
     * @return true if both instances are identical
     */
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        Water w = (Water) another;
        return name.equals(w.name) && amount == w.amount && unit == w.unit;
    }
    
    /**
     * @return a String explaining the particular Water instance
     */
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
