package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    /**
     * Constructor that initialises amount to 8 and decaf to false
     */
    public Coffee() {
        this(8, false);
    }


    /**
     * Constructor that takes the amount and decaf as parameters
     * and initialises decaf to false
     */
    public Coffee(int amount) {
        this(amount, false);
    }

    /**
     * Constructor that takes the amount and decaf as parameters.
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


    /**
     * Check if two objects are the same.
     * @param Object another to add a recipe to compare
     * @return True if another object is coffee and all parameters are same
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        Coffee coffee = (Coffee) another;
        return name.equals(coffee.getName()) && amount == coffee.amount && unit == coffee.unit && decaf == coffee.decaf;
    }
}
