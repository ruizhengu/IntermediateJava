package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
  private String flavour;

  public Syrup(){
    this("Salted Caramel", 20, Unit.ML);
  }
  public Syrup(String flavour){
    this(flavour, 20, Unit.ML);
  }

  public Syrup(String flavour, int amount){
    this(flavour, amount, Unit.ML);
  }

  public Syrup(String flavour, int amount, Unit unit){
    this.unit = Unit.ML;
    this.amount = 20;
    this.flavour = "Salted Caramel";
  }

  @Override
  public String toString() {
    return "Coffee [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
  }

  @Override
  public boolean equals(Object obj){
    if (obj == null || ! (obj instanceof Syrup))
      return false;

    Syrup sObj = (Syrup) obj;
    return super.equals(sObj) &&
            sObj.flavour.equals(this.flavour) &&
            sObj.amount == this.amount &&
            sObj.unit == this.unit;
  }
}
