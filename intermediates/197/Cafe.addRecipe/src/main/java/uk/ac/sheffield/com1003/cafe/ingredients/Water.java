package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    public Water(int amount) {
        this.amount = 50;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    public boolean equals(Water water) {
        //checks to see if all values are the same and if so returns true
        if (this.amount == water.getAmount() && this.name == water.getName()
            && this.unit == water.getUnit()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
