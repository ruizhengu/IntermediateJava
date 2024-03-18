package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * The Syrup class extends the Ingredient class to provide
 * extra functionality by using a private flavour variable and
 * by overriding the toString function to provide its own format.
 *
 * @author Yusuf Ibn Saifullah
 * @since 12-03-2023
 */
public class Syrup extends Ingredient {
  private String flavour;

  public Syrup() {
    this.name = "Syrup";
    this.unit = Unit.ML;
    this.amount = 15;
    this.flavour = "Chocolate";
  }

  public Syrup(String flavour) {
    this.name = "Syrup";
    this.unit = Unit.ML;
    this.amount = 15;
    this.flavour = flavour;
  }

  @Override
  public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
