package uk.ac.sheffield.com1003.cafe.ingredients;

public class VanillaExtract extends Ingredient {
    public VanillaExtract() {
        this.name = "Vanilla Extract";
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public VanillaExtract(int amount) {
        this.name = "Vanilla Extract";
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Vanilla Extract [unit=" + unit + ", amount=" + amount + "]";
    }
}
