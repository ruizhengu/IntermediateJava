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
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Water))
            return false;
        Water w = (Water) another;
        return name.equals(w.name) && amount == w.amount && unit == w.unit;
    }
}
