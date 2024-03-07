package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this.name = "Syrup";
        this.amount = 50;
        this.unit = Unit.ML;
        this.flavour = "Vanilla"; // default flavour of choice
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.amount = 50;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
