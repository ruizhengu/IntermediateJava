package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This is a child class of the abstract class ingredient used for the
 * coffee ingredient
 */

public class Coffee extends Ingredient {
    private boolean decaf;

    /**
     * Constructor that initialises ingredient amount to 8 and coffee decaf to 
     * false.
     */
    public Coffee() {
        this(8, false);
    }

    /**
     * Constructor that takes ingredient amount as parameter, and 
     * initialises coffee decaf to false.
     */
    public Coffee(int amount) {
        this(amount, false);
    }

    /**
     * Constructor that takes ingredient amount and coffee decaf as parameter, 
     * and initialises ingredient name to "Coffee" and unit to GR.
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    /**
     * @return Returns a string representation of the coffee in
     * the format "Coffee [unit=<unit>, amount=<amount>, decaf=<decaf>]"
     */
    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + 
                decaf + "]";
    }
}
