package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.unit = Unit.ML;
        this.name = "water";
        this.amount = 30;
    }

    public Water(int amount) {
        this.unit = Unit.ML;
        this.name = "water";
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
