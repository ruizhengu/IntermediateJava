package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * Class to represent coffee as an ingredient
 *
 * @author github-classroom
 *
 */
public class Coffee extends Ingredient {
    private boolean decaf;

    /**
     * Creates a new Coffee object with default amount of 8 grams and regular caffeinated coffee.
     */
    public Coffee() {
        this(8,false);
    }

  /**
   * Constructs a new Coffee object with a given amount of coffee and defaults the "iced" value to false.
   * @param amount the amount of coffee to use
   */
  public Coffee(int amount) {
        this(amount, false);
    }

    /**
     * Constructs a new Coffee object with a given amount of coffee and a given "iced" value.
     * @param amount the amount of coffee to use
     * @param decaf whether the coffee is decaf
     */
    public Coffee(int amount, boolean decaf) {
        this.name = "Coffee";
        this.amount = amount;
        this.unit = Unit.GR;
        this.decaf = decaf;
    }

    @Override
    public String toString() {
        return "Coffee [unit=" + unit + ", amount=" + amount + ", decaf=" + decaf + "]";
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

        // Check if the object is null or not an instance of Coffee
        if (obj == null || ! (obj instanceof Coffee)) {
            return false;
        }

        // Cast the object to a Coffee instance
        Coffee another = (Coffee) obj;

        // Check if the properties of the two Coffee objects are equal
        if (unit != another.unit) {
            return false;
        }
        if (amount != another.amount) {
            return false;
        }
        if (decaf != another.decaf) {
            return false;
        }
        return name.equals(another.name);
    }
}
