package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {
    public Water() {
        this(100);
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
}
