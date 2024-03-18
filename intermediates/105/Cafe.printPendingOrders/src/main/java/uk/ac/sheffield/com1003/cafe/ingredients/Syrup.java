package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    public Syrup(int amount) {
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = "Vanilla";
    }

    public Syrup(String flavour) {
        this.unit = Unit.ML;
        this.amount = 50;
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

