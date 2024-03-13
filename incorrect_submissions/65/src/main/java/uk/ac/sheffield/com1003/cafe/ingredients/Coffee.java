package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    public Coffee() {
        this(8, false);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    public Coffee(int amountGR) {
        this(amountGR, false);
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        // super.equals compares ingredient name
        if (super.equals(another)) {
            Coffee anotherCoffee = (Coffee) another;

            // Compare data in each instance variable (unit, amount, decaf)
            return anotherCoffee.unit == this.unit &&
                    anotherCoffee.amount == this.amount &&
                    anotherCoffee.decaf == this.decaf;
        }

        return false;
    }
}
