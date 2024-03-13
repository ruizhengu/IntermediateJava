package uk.ac.sheffield.com1003.cafe.ingredients;

/** 
 * Represents a syrup ingredient
 * @author Jakub Mikolajczak
 */
public class Syrup extends Ingredient{
    private String flavour;

    /**
     * Creates a syrup with a default amount and flavour
     * Default amount = 10
     * Default flavour = "Chocolate"
     */
    public Syrup() {
        this(10, "Chocolate");
    }
    
    /**
     * Creates a syrup with the specified amount and flavour
     * @param amount The amount of syrup
     * @param flavour The flavour of the syrup
     */
    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.flavour = flavour;
        this.amount = amount;
        this.unit = Unit.ML;
    }

    /**
     * Accessor - gets the flavour of the syrup
     * @return The flavour of the syrup
     */
    public String getFlavour() {
        return flavour;
    }

    /**
     * Converts the object to a string
     * @return a string containing the unit, amount and flavour of syrup
     */
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    /**
     * Determines if the syrup has the same amount, unit and flavour as another syrup
     * @param another The object to check that the syrup is equal to
     * @return True if the syrups are the same and false otherwise
     */
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;
        return name.equals(((Syrup)another).getName()) && amount == ((Syrup)another).getAmount() && unit == ((Syrup)another).getUnit()
            && flavour == ((Syrup)another).getFlavour();
    }
}
