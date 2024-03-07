package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;
    public Syrup(String flavour) {
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = 40;
    }

    public String getFlavour() {
        return this.flavour;
    }

    public String toString() {
        return ("Syrup = [unit=" + this.getUnit() + ", amount=" + this.getAmount() + ", flavour=" + this.getFlavour() + "]");
    }
}
