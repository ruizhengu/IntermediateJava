package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    
    private String flavour;

    public Syrup() {
        this.name = "Syrup";
        this.amount = 30;
        this.unit = Unit.ML;
        this.flavour = "Apple";
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.amount = 30;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
