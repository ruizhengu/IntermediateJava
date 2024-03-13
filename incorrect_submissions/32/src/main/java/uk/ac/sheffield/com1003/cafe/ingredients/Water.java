package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This is a child class of the abstract class ingredient used for the
 * water ingredient
 */

public class Water extends Ingredient {

    /**
     * Constructor that initialises ingredient amount to 30.
     */
    public Water() {
        this(30);
    }

    /**
     * Constructor that takes ingredient amount as parameter, 
     * and initialises ingredient name to "Water", unit to ML.
     */
    public Water(int amount) {
        this.amount = amount;
        this.name = "Water";
        this.unit = Unit.ML;
    }

    /**
     * @return Returns a string representation of the water in
     * the format "Water [unit=<unit>, amount=<amount>]"
     */
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
    }
}
