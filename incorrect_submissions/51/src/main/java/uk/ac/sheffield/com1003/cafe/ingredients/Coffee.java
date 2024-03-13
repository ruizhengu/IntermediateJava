package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;
    
    /**
     * Updated constructor Coffee() that sets all the instances variables with the correct values.
     */
    public Coffee() {
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.decaf = false;
        this.amount = 8;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    /**
     * Constructor that takes the amount of coffee as parameters.
     * @param amount
     */
    public Coffee(int amount) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
