package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    public Syrup(String flavour) {
        super();
        this.name = "Syrup";
        this.flavour = flavour;
        this.amount = 10;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
