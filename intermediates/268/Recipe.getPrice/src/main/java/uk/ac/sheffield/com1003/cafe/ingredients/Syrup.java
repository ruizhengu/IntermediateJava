package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    /**
     * Default Constructor
     */
    public Syrup() {
        name = "Syrup";
        unit = Unit.ML;
        amount = 10;
        this.flavour = "Vanilla";
    }

    /**
     * Constructor with flavour argument
     * @param flavour
     */
    public Syrup(String flavour) {
        name = "Syrup";
        unit = Unit.ML;
        amount = 10;
        this.flavour = flavour;
    }

    /**
     * Override toString() method
     * @return
     */
    @Override
    public String toString() {
        return String.format("Syrup [unit=%s, amount=%d, flavour=%s]", this.getUnit(), this.getAmount(), this.flavour);
    }
}
