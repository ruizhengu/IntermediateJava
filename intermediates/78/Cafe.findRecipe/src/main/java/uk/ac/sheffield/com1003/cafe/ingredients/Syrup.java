package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
  private String flavour;

  public Syrup() {
    this.unit = Unit.ML;
    this.amount = 50;
    this.flavour = "Maple Syrup";
  }
  
  public Syrup(String flavour) {
    this.flavour = flavour;
  }

  public String toString() {
    return ("Syrup [unit=" + this.unit + ", amount=" + this.amount + ", flavour=" + this.flavour + "]");
  }
}
