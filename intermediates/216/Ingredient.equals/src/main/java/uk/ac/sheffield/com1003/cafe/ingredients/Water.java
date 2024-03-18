package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this.amount = 30;
        this.unit = Unit.ML;
        this.name = "Water";
    }

    public Water(int theAmountOfWater) {
        this.amount = theAmountOfWater;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
