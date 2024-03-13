package uk.ac.sheffield.com1003.cafe.ingredients;
/** 
 * Represents water ingredient in a Recipe
*/
public class Water extends Ingredient {

    static final int DEFAULT_AMOUNT = 30;

    public Water() {
        this(DEFAULT_AMOUNT);
    }

    public Water(int amount) {
        this.name = "Water";
        this.unit = Unit.ML;
        this.amount = amount > 0 ? amount : DEFAULT_AMOUNT;
    }

    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
