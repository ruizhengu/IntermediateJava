package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        name = "Water";
        unit = Unit.ML;
    }

    public Water(int amount) {
        this.amount = amount;
        name = "Water";
        unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
