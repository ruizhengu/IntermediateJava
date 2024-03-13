package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(String flavour) {
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = 10;
    }

    public Syrup() {
        this.flavour = "Vanilla";
        this.unit = Unit.ML;
        this.amount = 10;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
