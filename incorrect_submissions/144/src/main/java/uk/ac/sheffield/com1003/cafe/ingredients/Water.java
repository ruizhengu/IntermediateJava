package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.name = "water";
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public Water(int amount) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
