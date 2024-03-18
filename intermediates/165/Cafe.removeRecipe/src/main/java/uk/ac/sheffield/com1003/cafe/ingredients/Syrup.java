package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;
    private Unit unit;
    
    /**
     * Constructor that initialises flavour to "vanilla", units
     * to ML and amount to 10.
     */
    public Syrup(){
        this.flavour = "vanilla";
        this.unit = Unit.ML;
        this.amount = 10;
    }

    /**
     * Constructor that initialises flavour to its parameter,
     * units to ML and amount to 10
     * @param flavour sets the flavour of the syrup
     */
    public Syrup(String flavour) {
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = flavour;
    }

    /**
     * Constructor that initialises flavour and amount from params,
     * units to ML and amount to 10
     * @param flavour sets the flavour of the syrup
     *  @param amount sets the amount of syrup
     */
    public Syrup(String flavour, int amount) {
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }


    // override toString to display properties of the syrup
    @Override
    public String toString() {
        return "Syrup [unit=" + this.unit.toString() + 
        ", amount=" + Integer.toString(this.amount) + 
        ", flavour=" + this.flavour + "]";
    }
}
