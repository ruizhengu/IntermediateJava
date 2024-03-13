package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * This class is used to instantiate Syrup objects.
 * As well as the inherited name, unit and amount, Syrup objects have the attribute flavour
 * It also overrides toString and equals methods to make them more specific to Syrup objects
 */
public class Syrup extends Ingredient{

    private String flavour;

    /**
     * Default constructor for Syrup
     */
    public Syrup() {
        this(10, "chocolate");
    }

    /**
     * Another constructor for Syrup taking the flavour as an input
     * @param flavour the flavour of the Syrup
     */
    public Syrup(String flavour) {
        this(10, flavour);
    }

    /**
     * Another constructor for Syrup taking the amount and flavour as an input
     * @param flavour the flavour of the Syrup
     * @param amount the amount of Syrup to be added in millilitres
     */
    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    public String getFlavour() { return this.flavour; }

    /**
     * Compares another object with this Syrup type object and returns whether they are the same
     * Overrides the equals method in the parent class
     *
     * @param another a pointer to the object that this object is being compared to
     * @return true if they are considered equal, false otherwise
     */

    @Override
    public boolean equals(Object another){
        if (!(another instanceof Syrup)) {
            return false;
        }
        else {
            // Cast "another" to a Syrup object so that we can call getFlavour() on it
            Syrup otherIngredient = (Syrup)another;
            return (this.name.equals(otherIngredient.getName()) &&
                    this.amount == otherIngredient.getAmount() &&
                    this.unit == otherIngredient.getUnit() &&
                    this.flavour.equals(otherIngredient.getFlavour()));
        }
    }

    /**
     * A toString method overriding the one in the Ingredient superclass
     * @return a clear display of the relevant instance variables for this Syrup object
     */
    @Override
    public String toString() {
        return "Syrup [unit="+this.unit+", amount="+this.amount+", flavour="+this.flavour+"]";
    }
}
