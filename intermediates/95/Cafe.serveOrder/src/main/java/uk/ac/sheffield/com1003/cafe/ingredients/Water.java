package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This class represents a Water Ingredient which extends the Ingredient class.
 * It has a default constructor and an overloaded constructor with the amount as an argument.
 * It also has an overridden toString() method to return the Water's properties.
 */
public class Water extends Ingredient {

    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }

    public Water(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
