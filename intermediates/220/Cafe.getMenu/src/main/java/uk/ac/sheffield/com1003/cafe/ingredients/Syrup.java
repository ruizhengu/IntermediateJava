package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    String flavour;

    public Syrup() {
        this.name = "Syrup";
        //this is my favourite syrup to have in coffee
        this.flavour = "Hazelnut";
        this.amount = 25;
        this.unit = Unit.ML;
    }

    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.flavour = flavour;
        this.amount = amount;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour +"]";
    }
}
