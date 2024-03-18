package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;


    /**
     * Constructor that initialises flavour to "Maple",
     * amount to 15 and unit to ML
     */
    public Syrup() {
        this("Maple");
    }

    /**
     * Constructor that takes flavour as a parameter,
     * initialises amount to 15 and unit to ML
     */
    public Syrup(String flavour) {
        this.flavour = flavour;
        this.amount = 15;
        this.unit = Unit.ML;
    }

    /**
     * @return Returns a string representation of syrup in
     * the format "Syrup: [unit=<Unit Type>, amount=<Amount of syrup>, flavour=<Flavour>]"
     */
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
