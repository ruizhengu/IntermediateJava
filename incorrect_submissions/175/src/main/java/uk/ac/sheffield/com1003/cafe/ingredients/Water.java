package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    //default
    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }
    //properties in double espresso instance
    public Water(int amount) {
        this.amount = 50;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
