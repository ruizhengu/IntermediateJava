package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.amount = 8;
        this.decaf = false;
        this.unit = Unit.GR;
        this.name = "Coffee";
    }

    public Coffee(int amount) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = false;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    /**
     * @return if coffee is decaf
     */
    public boolean getDecaf() {
        return this.decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;

        Coffee other = (Coffee) another;

        if (other.getUnit() != getUnit()) {
            return false;
        }

        if (other.getAmount() != getAmount()) {
            return false;
        }

        if (other.getDecaf() != getDecaf()) {
            return false;
        }

        return true;
    }
}
