package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.amount = 8;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }
    public Coffee(int amount) {

        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public boolean isDecaf() { return decaf; }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;

        Coffee other = (Coffee) another;
        return name.equals(other.getName()) &&
                amount == other.getAmount() &&
                unit == other.getUnit() &&
                decaf == other.isDecaf();
    }
}
