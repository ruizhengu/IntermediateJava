package uk.ac.sheffield.com1003.cafe.ingredients;
/**
 * Syrup is a subclass of Ingredient that represents a type of syrup used in drinks. It has a flavour and can be measured in milliliters.
 */
public class Syrup extends Ingredient {
    private String flavour;

    /**
     * Constructs a new Syrup object with a default amount of 20 mL and a default flavour of "hazelnut".
     */
    public Syrup() {
        this.name = "Syrup";
        this.unit = Unit.ML;
        // default amount of 20 mL
        this.amount = 20;
        // default flavour
        this.flavour = "hazelnut";
    }

    /**
     * Constructs a new Syrup object with the specified flavour.
     *
     * @param flavour the flavour of the syrup
     */
    public Syrup(String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 20;
        this.flavour = flavour;
    }

    /**
     * Constructs a new Syrup object with the specified flavour and amount.
     *
     * @param flavour the flavour of the syrup
     * @param amount the amount of syrup, in milliliters
     */
    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }


    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (! (another instanceof Syrup)) {
            return false;
        }

        Syrup otherSyrup = (Syrup) another;
        return this.name.equals(otherSyrup.name) && this.unit.equals(otherSyrup.unit)
                && this.amount == otherSyrup.amount && this.flavour.equals(otherSyrup.flavour);
    }
}