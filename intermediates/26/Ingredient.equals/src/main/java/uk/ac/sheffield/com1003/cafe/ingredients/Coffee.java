package uk.ac.sheffield.com1003.cafe.ingredients;
/** 
 * Represents coffee ingredient in a Recipe
*/
public class Coffee extends Ingredient {
    private boolean decaf;

    static final boolean DEFAULT_CAFFINATION = false;
    static final int DEFAULT_AMOUNT = 8;

    public Coffee() {
        this(DEFAULT_AMOUNT,DEFAULT_CAFFINATION);
    }

    public Coffee(int amount) {
        this(amount,DEFAULT_CAFFINATION);
    }

    public Coffee(boolean decaf) {
        this(DEFAULT_AMOUNT,decaf);
    }

    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount > 0 ? amount : DEFAULT_AMOUNT;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
