package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(String flavour, int amount) {
      this.flavour = flavour;
      this.unit = Unit.ML;
      this.amount = amount;
    }

    public Syrup(String flavour) {
      this.flavour = flavour;
    }

    public Syrup() {
      this.unit = Unit.ML;
      this.amount = 25;
      this.flavour = "Chocolate";
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

}
