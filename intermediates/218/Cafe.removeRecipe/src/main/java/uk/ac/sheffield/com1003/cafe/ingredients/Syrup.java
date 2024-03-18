package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    
    private String flavour;

/**
 * Default constructor for the Syrup class.
 * Sets a standard unit attribute to milliliters, the amount attribute to 10, and the flavour attribute to "orange".
 */
    public Syrup() {
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = "orange";
    }

/**
 * Created a constructor for the Syrup class.
 * Initialised the amount and flavour attributes with the values passed as parameters.
 * The unit attribute is set to milliliters.
 * 
 * @param flavour the flavour of the syrup
 * @param amount the amount of syrup, measured in milliliters
 */

    public Syrup(String flavour, int amount) {
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

/**
 * Returns a string of the Syrup object, containing information about its unit, amount, and flavour.
 * 
 * @return a string representation of the Syrup object
 */
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

}
