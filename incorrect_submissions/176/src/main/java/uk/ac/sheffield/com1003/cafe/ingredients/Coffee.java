package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.amount = 8;
        this.decaf = false;
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.unit = Unit.GR;
        this.amount = amount;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Coffee))
            return false;
        return this.name.equals(((Coffee)another).getName()) && this.unit.equals(((Coffee)another).getUnit()) &&
                this.amount == ((Coffee)another).getAmount() && this.decaf == ((Coffee)another).decaf;
    }
}
