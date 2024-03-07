package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    public Water() {
        this(30);
    }
    public Water(int amount) {
    	this.name = "Milk";
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
