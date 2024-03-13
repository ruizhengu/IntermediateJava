package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * Class to represent water as an ingredient
 *
 * @author github-classroom
 *
 */
public class Water extends Ingredient {

    public Water() {
        this(8);
    }

  /**
   * Constructor for Water class
   * @param amount the amount of water to be created
   */
  public Water(int amount) {
        this.name = "Water";
        this.amount = amount;
        this.unit = Unit.ML;
    }
    @Override
    public String toString() {
        return "Water [unit=" + unit + ", amount=" + amount + "]";
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
        return name.equals(another.name);
    }
}
