package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8);
    }

    public Coffee(int amount) {
        this(amount, false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public boolean getDecaf() {
        return this.decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Coffee))
            return false;
        return this.getUnit().equals(((Coffee) another).getUnit()) && this.getAmount() == ((Coffee) another).getAmount()
                && this.getDecaf() == ((Coffee) another).getDecaf()
                && this.getName().equals(((Coffee) another).getName());
    }
}
