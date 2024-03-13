package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }

    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
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
