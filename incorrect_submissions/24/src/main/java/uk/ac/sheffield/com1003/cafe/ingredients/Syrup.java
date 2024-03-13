package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * Class to represent syrup as an ingredient
 *
 * @author Xinye Yang
 *
 */
public class Syrup extends Ingredient{
    private String flavour;

    /**
     * Constructor for creating a Syrup object with default values of 5 as amount and "chocolate" as flavor
     */
    public Syrup() {
        this(5, "chocolate");
    }

    /**
     * Creates a new Syrup object with the specified amount and default flavor "chocolate".
     * @param amount the amount of syrup to be created.
     */
    public Syrup(int amount) {
        this(amount, "chocolate");
    }

    /**
    * Creates a new instance of Syrup with the given amount and flavour.
    * @param amount the amount of the syrup, in grams
    * @param flavour the flavour of the syrup
    */
    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.GR;
        this.flavour = flavour;
    }

  /**
   * Returns a string representation of the Syrup object.
   * @return a string in the format "Syrup [unit=<unit>, amount=<amount>, flavour=<flavour>]"
   */
  @Override
  public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj The reference object with which to compare.
     *
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        // Check if the object is null or not an instance of Syrup
        if (obj == null || !(obj instanceof Syrup)) {
            return false;
        }

        // Cast the object to a Syrup instance
        Syrup another = (Syrup) obj;

        // Check if the properties of the two Syrup objects are equal
        if (unit != another.unit) {
            return false;
        }
        if (amount != another.amount) {
            return false;
        }
        if (!flavour.equals(another.flavour)) {
            return false;
        }
        return name.equals(another.name);
    }
}
