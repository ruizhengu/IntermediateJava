package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup() {
        this.flavour = "Chocolate";
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" +flavour +"]";
    }
}
