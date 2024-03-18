package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this.name = "Syrup";
        unit = Unit.ML;
        amount = 2;
        flavour = "Caramel";
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.amount = 2;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
