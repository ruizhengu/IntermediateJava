package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * Subclass of Ingredient with an extra flavour attribute.
 * Can be used in Recipe objects.
 */
public class Syrup extends Ingredient {

    private String flavour;

    /**
     * Default constructor sets the name to "Syrup", unit to ML, amount to 5(ml), and flavour to "Pistachio"
     */
    public Syrup() {
        this("Pistachio");
    }

    /**
     * Sets flavour to the given value. Other variables have default constructor values.
     * @param flavour The flavour of this syrup
     */
    public Syrup(String flavour) {
        this.unit = Unit.ML;
        this.amount = 5;
        this.name = "Syrup";
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        // super.equals compares ingredient name
        if (super.equals(another)) {
            Syrup anotherSyrup = (Syrup) another;

            // Compare data in each instance variable (unit, amount, flavour)
            return anotherSyrup.unit == this.unit &&
                    anotherSyrup.amount == this.amount &&
                    anotherSyrup.flavour.equals(this.flavour);
        }

        return false;
    }
}
