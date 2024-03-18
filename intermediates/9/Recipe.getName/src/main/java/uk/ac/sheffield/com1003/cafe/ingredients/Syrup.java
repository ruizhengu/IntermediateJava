package uk.ac.sheffield.com1003.cafe.ingredients;



public class Syrup extends Ingredient {
    private String flavour;
    /**
     * Creates a default constructor for a Syrup ingredient. Sets the unit to ML, the amount to 50, and the flavour to "Chocolate".
     */
    public Syrup(){
        this.unit = Unit.ML;
        this.amount = 50;
        this.flavour = "Chocolate";
    }
    /**
     * Creates a constructor for a Syrup ingredient. that take a flavour parameter.
     * Sets the unit to ML, the amount to 50, and the flavour to the input value.
     * @param flavour allows user to specify a flavour of the syrup
     */
    public Syrup(String flavour){
        this.unit = Unit.ML;
        this.amount = 50;
        this.flavour = flavour;
    }
    /**
     * Returns the syrup object as a string with its details
     * @return a string with the unit, amount, and flavour of the Syrup object
     */
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
