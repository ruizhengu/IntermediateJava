package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    /**
     * Construct for Syrup without any attributes.
     * Sets flavour to "Vanilla", amount to 30, and enum Unit to ML by default.
     */
    public Syrup() {
        this("Vanilla", 30, Unit.ML);
    }

    /**
     * Constructor for Syrup with all attributes set.
     * @param flavour Name of the flavour of syrup.
     * @param amount Integer amount of syrup to use in the Recipe.
     * @param unit Measurement type of syrup as an enum of Unit.
     */
    public Syrup(String flavour, int amount, Unit unit) {
        this.flavour = flavour;
        this.name = "Syrup";
        this.amount = amount;
        this.unit = unit;
    }

    /**
     * Get value of private attribute flavour.
     * @return Name of private attribute flavour as a string.
     */
    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [Unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + getFlavour() + "]";
    }
}
