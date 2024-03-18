package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Fruit");
    }

    public Syrup(String flavor) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 15;
        this.flavour = flavor;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
