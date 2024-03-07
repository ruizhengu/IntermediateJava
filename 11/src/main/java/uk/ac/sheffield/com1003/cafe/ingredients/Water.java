package uk.ac.sheffield.com1003.cafe.ingredients;

public class Water extends Ingredient {
    /**
     * made another public Water() to pass the TooManyIngredientsException
     */
    public Water() {
        this.name = "Water";
        this.amount = 30;
        this.unit = Unit.ML;
    }

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
