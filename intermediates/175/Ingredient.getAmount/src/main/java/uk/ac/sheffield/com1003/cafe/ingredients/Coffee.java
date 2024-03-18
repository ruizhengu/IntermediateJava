package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;
    private int amount;

    //default
    public Coffee() {
        this.amount = 8;
    }
    //properties in double espresso instance
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = 15;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
