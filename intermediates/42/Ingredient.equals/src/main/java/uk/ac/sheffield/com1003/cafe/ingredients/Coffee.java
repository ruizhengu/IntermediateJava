package uk.ac.sheffield.com1003.cafe.ingredients;

public class Coffee extends Ingredient {
    private boolean decaf;

    /**
     * constructor that initialises amount as 8g, name as 'Coffee',
     * decaf as false and unit as grams
     */
    public Coffee() {
        this(8, false);
    }

    /**
     * constructor that initialises name as 'Coffee', unit as grams
     * and decaf and amount as whatever the user passes in as parameters
     * 
     * @param amount the user's desired amount
     * @param decaf whether the coffee is decaf or not
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
    }
}
