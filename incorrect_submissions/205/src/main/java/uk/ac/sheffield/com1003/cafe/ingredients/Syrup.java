package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * New syrup class for task 6 follows similar pattern to other classes in ingredients directory.
 */


public class Syrup extends Ingredient  {
  private String flavour;

  public Syrup() {
    this.amount = 74;
    this.flavour = "Maple";
    this.unit = Unit.ML;
  }

  public Syrup(String flavour) {
    this.flavour = flavour;
    this.unit = Unit.ML;
    this.amount = 74;
  }

  public Syrup(int amount, String flavour) {
    this.flavour = flavour;
    this.amount = amount;
    this.unit = Unit.ML;
  }
  @Override
  public String toString() {
    return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
  }
}
