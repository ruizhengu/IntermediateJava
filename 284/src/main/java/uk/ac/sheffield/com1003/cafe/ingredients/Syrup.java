package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * Represents a syrup ingredient that can be added to a recipe.
 * The syrup has a specified flavour, amount, and unit.
 */
public class Syrup extends Ingredient {
  private String flavour;

  /**
   * this constructor takes the flavour of the syrup as a parameter and sets the flavour to that
   * @param flavour
   */
  public Syrup(String flavour) {
    this.flavour = flavour;
  }

  /**
   * this constructor sets the default state for the syrup
   * which is 30ML and the flavour is chocolate
   */
  public Syrup() {
    this.unit = Unit.ML;
    this.amount = 30;
    this.flavour = "Chocolate";
  }

  @Override
  public String toString() {
    return (
      "Syrup [ unit = " +
      this.unit +
      " , amount = " +
      this.amount +
      " , flavour= " +
      this.flavour +
      " ]"
    );
  }
}
