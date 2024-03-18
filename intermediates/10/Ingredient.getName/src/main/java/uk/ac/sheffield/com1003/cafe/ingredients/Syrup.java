package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private final String flavour;

    public Syrup() {
        this.flavour = "Maple";
    }
    public Syrup(int amount, String flavour) {
        this.flavour = flavour;
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour +"]"; }
}
