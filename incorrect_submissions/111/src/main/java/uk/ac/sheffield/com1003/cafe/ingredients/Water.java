package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {
    public Water() {
        this(30);
    }

    /**
     * Constructor for Water with attribute amount.
     * Sets name to Water and enum Unit to ML my Default.
     * @param amount Integer amount of water (in ML) to use in the Recipe.
     */
    public Water(int amount) {
        this.amount = amount;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
