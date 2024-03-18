package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
  private String flavour = "Vanilla";
  
  public Syrup() {
    this("Vanilla", 8);
  }

  public Syrup(String flavour) {
    this(flavour, 8);
  }

  public Syrup(String flavour, int amount) {
    this.name = "Syrup";
    this.unit = Unit.ML;
    this.amount = amount;
    this.flavour = flavour;
  }

  @Override
  public String toString() {
      return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
  }

}
