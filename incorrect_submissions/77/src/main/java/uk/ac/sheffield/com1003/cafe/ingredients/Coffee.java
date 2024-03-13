package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public boolean getDecaf() { return this.decaf; }

    /***
     * Creates a new instance of the Coffee ingredient
     * @see Coffee#Coffee(int amount)
     * @see Coffee#Coffee(int amount, boolean decaf)
     */
    public Coffee() { this(8, false); }

    /***
     * Creates a new instance of the Coffee ingredient
     * @param amount Amount of coffee in grams
     * @see Coffee#Coffee()
     * @see Coffee#Coffee(int amount, boolean decaf)
     */
    public Coffee(int amount) { this(amount, false); }

    /***
     * Creates a new instance of the Coffee ingredient
     * @param amount Amount of coffee in grams
     * @param decaf Whether the coffee is decaf or not
     * @see Coffee#Coffee()
     * @see Coffee#Coffee(int amount)
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return this.name + " [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object other){
        // Handle edge cases
        if (!(other instanceof Coffee))
            return false;
        if (this == other)
            return true;
        // Check if all super values are equal
        boolean equals = super.equals(other);
        // Check all instance variables
        Coffee otherCoffee = (Coffee) other;
        return equals && (amount == otherCoffee.getAmount())
                && (unit == otherCoffee.getUnit())
                && (decaf == otherCoffee.getDecaf());


    }
}
