package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {
/**
 * Creates a default constructor with a default amount of 30 ml.
 */
    public Water() {
        this.amount = 30;
        this.name = "Water";
        this.unit = unit.ML;

    }
/**
 * Constructs a Water object with a given amount.
 * 
 * @param amount the amount of water in ml
 */
    public Water(int amount) {
        this.amount = amount;
    }
/**
 * Returns a String of the Water object representing its information
 * 
 * @return a String of the Water object representing its information
 */
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
