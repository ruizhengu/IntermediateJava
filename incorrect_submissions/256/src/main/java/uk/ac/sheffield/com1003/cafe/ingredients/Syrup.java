package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    //default constructor
    public Syrup() {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 5;
        this.flavour = "Vanilla";
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}

