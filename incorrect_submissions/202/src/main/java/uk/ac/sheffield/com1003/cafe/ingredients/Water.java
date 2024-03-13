package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }
    public Water(int amount) {
        this.amount = amount;
        this.unit = Unit.ML; // set the unit to a default value
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
