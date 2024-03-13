package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(String flavour) {
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = 25; // default amount of 25 mL
    }

    public Syrup() {
        this("Vanilla"); // default flavour of vanilla
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
