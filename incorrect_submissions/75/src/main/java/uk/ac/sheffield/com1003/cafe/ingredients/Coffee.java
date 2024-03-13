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
        if (another == null || ! (another instanceof Coffee)) {
            return false;
        }
        else {
            Coffee otherIngredient = (Coffee)another;
            if (this.name == otherIngredient.getName() && this.unit == otherIngredient.getUnit() 
                && this.amount == otherIngredient.getAmount() 
                    && this.decaf == otherIngredient.decaf) {
                
                return true;
            }
        }

        return false;
    }
}
