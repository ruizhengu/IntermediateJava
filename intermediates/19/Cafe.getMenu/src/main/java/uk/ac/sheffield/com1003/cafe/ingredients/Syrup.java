package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Apple");
    }

    public Syrup(String flavour) {
        this(30, flavour);
    }

    public Syrup(int amount, String flavour) {
        this.amount = amount;
        this.flavour = flavour;
        this.name = "Syrup";
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
