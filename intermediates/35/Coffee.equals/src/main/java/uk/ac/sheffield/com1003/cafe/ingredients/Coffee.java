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

    @Override
    public boolean equals(Object another) {
        if (this == another) {
            return true;
        }
        if (another == null) {
            return false;
        }

        if (another instanceof Coffee) {
            Coffee otherCoffee = (Coffee) another;
            if (name == otherCoffee.getName()
                    && amount == otherCoffee.getAmount()
                    && unit == otherCoffee.getUnit()
                    && decaf == otherCoffee.decaf) {
                return true;

            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
