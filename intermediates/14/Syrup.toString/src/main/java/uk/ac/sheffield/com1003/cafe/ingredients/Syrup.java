package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this(10, "Caramel");
    }

    public Syrup(String flavour) {
        this(10, flavour);
    }

    public Syrup(int amount, String flavour) {
        this.amount = amount;
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.name = "Syrup";
    }

    @Override
    public String toString() {
        return "Syrup[unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
