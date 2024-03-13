package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This class represents the Syrup ingredient which is a subclass of Ingredient.
 * It contains attributes such as the name, unit, amount and flavour of the syrup.
 * It also provides constructors to set the flavour and methods to get the flavour.  
 */
public class Syrup extends Ingredient {

    private String flavour;

    public Syrup() {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 30;
        this.flavour = "Strawberry";
    }

    public Syrup(String flavour) {
        this.flavour = flavour;

    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + getFlavour() + "]";
    }
}
