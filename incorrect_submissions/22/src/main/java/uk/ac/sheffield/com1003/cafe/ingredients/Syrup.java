package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup  extends Ingredient{
    private String flavour;

    public Syrup() {
        this.unit = Unit.ML;
        this.amount = 15;
        this.flavour = "Vanilla";
    }

    public Syrup (String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return ("Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]");
    }
}
