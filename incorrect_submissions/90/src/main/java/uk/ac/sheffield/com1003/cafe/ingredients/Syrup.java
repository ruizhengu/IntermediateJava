package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    String flavour;

    public Syrup () {
        this ("Honey");
    }

    public Syrup (String flavour) {
        this (flavour, 10);
    }

    public Syrup (String flavour, int amount) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Milk [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
