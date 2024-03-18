package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8, false);
    }

    /**
     * Constructor for Coffee only with amount attribute.
     * Sets decaf to false by default.
     * @param amount Integer amount of coffee for the Recipe.
     */
    public Coffee(int amount) {
        this(amount, false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    /**
     * Getter method for the private attribute decaf
     * @return the private decaf attribute.
     */
    public boolean getDecaf() { return this.decaf; }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
