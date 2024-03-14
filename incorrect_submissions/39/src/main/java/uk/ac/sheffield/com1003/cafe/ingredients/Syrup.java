package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(String flavour) {
        this.flavour = flavour;
    }

    public Syrup() {
        this.flavour = "Vanilla";
        this.amount = 30;
        this.unit = Unit.ML;
    }

    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavor=" + flavour + "]";
    }
}
