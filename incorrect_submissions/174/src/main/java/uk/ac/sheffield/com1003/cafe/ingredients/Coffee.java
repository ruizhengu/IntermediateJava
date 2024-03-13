package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    /**
     * Constructor that takes the coffee name as "Coffee",
     * amount of 8 in unit grams
     * and as not decaf.
     */

    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    /**
     * Constructor that takes the amount of
     * coffee as parameters and gives it in gram unit.
     */
    public Coffee(int amount){
        this.amount = amount;
        this.unit = Unit.GR;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    /**
     * @return Returns a string representation of the coffee in
     * the format "Coffee: [unit= <unit>, amount=<amount>, decaf=<decaf>]"
     */
    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

}
