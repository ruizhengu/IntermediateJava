package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf = false;
    public Coffee() {
        this(8);
    }
    public Coffee(int amount) {
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.amount = amount;
    }
    public Coffee(int amount, boolean decaf) {
        this(amount);
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
