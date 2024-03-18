package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This is a child class of the abstract class ingredient used for the
 * syrup ingredient
 */

public class Syrup extends Ingredient {
    private int flavour;

    /**
     * Constructor that initialises syrup flavour to 50.
     */
    public Syrup() {
        this(50);
    }

    /**
     * Constructor that takes syrup flavour as parameter, 
     * and initialises ingredient name to "Syrup", unit to ML, 
     * and ingredient amount to 10.
     */
    public Syrup(int flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = flavour;
    }

    /**
     * @return Returns a string representation of the syrup in
     * the format "Syrup [unit=<unit>, amount=<amount>, flavour=<flavour>]"
     */
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + 
                flavour + "]";
    }
}
