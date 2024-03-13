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

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient)) {
            return false;
        }
        
        Ingredient ingredient = (Ingredient) another;

        if (this.getName() == ingredient.getName() &&
        this.getAmount() == ingredient.getAmount() &&
        this.getUnit() == ingredient.getUnit()) {
            return true;
        }
        else {
            return false;
        }
    }
}
