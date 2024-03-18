package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;
    public Syrup(String flavour) {
        this.amount = 25;
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = flavour;
    }
    public Syrup() {
        this("Hazelnut");
    }
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
