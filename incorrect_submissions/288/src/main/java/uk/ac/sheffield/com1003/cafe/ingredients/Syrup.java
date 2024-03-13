package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * Syrup class represents an ingredient that can be added to a drink
 * to enhance its flavor. It extends the Ingredient class.
 */
public class Syrup extends Ingredient {

    // The flavor of the syrup
    private String flavour;

    /**
     * Constructs a new Syrup object with the given flavor.
     *
     * @param flavour The flavor of the syrup.
     */
    public Syrup(String flavour) {
        super();
        this.flavour = flavour;
    }

    /**
     * Returns the flavor of the syrup.
     *
     * @return The flavor of the syrup.
     */
    public String getFlavour() {
        return flavour;
    }

    /**
     * Sets the flavor of the syrup.
     *
     * @param flavour The new flavor of the syrup.
     */
    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    /**
     * Returns a string representation of the syrup in the format:
     * "<flavour> syrup"
     *
     * @return A string representation of the syrup.
     */
    @Override
    public String toString() {
        return flavour + " syrup";
    }
}
