package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {this.amount = 50;}

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    // default constructor
    public Syrup(int amount) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = "caramel";
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + getUnit() + ", amount=" + getAmount() + ", flavour=" + flavour + "]";
    }
}