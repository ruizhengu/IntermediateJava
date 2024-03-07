package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private final String flavour;

    public Syrup(String flavour) {
        this(10, flavour);
    }

    public Syrup(int amount, String flavour) {
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.name = "Syrup";
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + this.unit + ", amount=" + this.amount + ", flavour=" + this.flavour + "]";
    }
}
