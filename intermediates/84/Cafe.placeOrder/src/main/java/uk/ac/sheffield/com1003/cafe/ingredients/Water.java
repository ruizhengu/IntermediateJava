package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

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

    //TASK 5
    public boolean equals(Water wtr) {
        if (wtr == null || ! (wtr instanceof Water)
                || ! (amount == wtr.getAmount())
                || ! (unit == wtr.getUnit() ) )
            return false;
        return true;
    }
}
