package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    String flavour;

    public Syrup() {
        this("Chocolate");
    }

    public Syrup(String flavour) {
        unit = Unit.ML;
        amount = 30;
        this.flavour = flavour;
    }

    public String getFlavour() { return flavour; }

    @Override
    public String toString() {
        return  "Syrup [unit=" + String.valueOf(getUnit()) + ", amount=" + getAmount() + ", flavour=" + getFlavour() + "]";
    }
}
