package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    /* Constructor with no parameters, sets default values */
    public Water() {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public Water(int amount) {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }

    /* Method to return true if two water objects are the same */
    @Override
    public boolean equals(Object another) {
        if (another == null || getClass() != another.getClass())
            return false;
        /* If the class is the same, each  specific attribute is compared */
        Water anotherWater = (Water) another;
        if (this.getName() == anotherWater.getName()) {
            if (this.getAmount() == anotherWater.getAmount()) {
                if (this.getUnit() == anotherWater.getUnit()) {
                    return true;
                }
            }
        }
        return false;
    }
}
