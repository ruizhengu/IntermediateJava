package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {

    /**
     * Updated constructor Water() that sets all the instances variables with the correct values.
     */
    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }
    /**
     * Constructor that takes the amount of water as parameters.
     * @param amount
     */
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
