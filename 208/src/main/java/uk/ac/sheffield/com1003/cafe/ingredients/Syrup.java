package uk.ac.sheffield.com1003.cafe.ingredients;
/**
 * This class represents syrup.
 * It is a subclass of the Ingredient class.
 * It has attributes for its name, unit, amount and flavour.
 */
public class Syrup extends Ingredient {

    private String flavour;

    public Syrup() {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 5;
        this.flavour = "golden";
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 5;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour;
    }

}
