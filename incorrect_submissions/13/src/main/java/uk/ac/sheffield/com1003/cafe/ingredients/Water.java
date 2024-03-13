package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    /*constructor that sets the default amount of water to 30ml*/
    public Water() { this(30); }

    /*constructor that sets the amount of water to a given parameter*/
    public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
