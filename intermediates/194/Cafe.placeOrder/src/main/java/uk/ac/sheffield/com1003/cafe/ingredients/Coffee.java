package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * Subclass of Ingredient for Coffee; contains other features including default constructor and overridden methods
 * @author milan
 */
public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() { //default constructor
        this.amount = 8;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    public Coffee (int amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        Coffee coffee = (Coffee) another;
        return name.equals(coffee.getName()) && amount == coffee.amount && unit == coffee.unit && decaf == coffee.decaf;
    }
}
