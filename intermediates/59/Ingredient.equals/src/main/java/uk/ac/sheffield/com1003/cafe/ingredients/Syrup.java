package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup() {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = "sweet";
        this.amount = 10;
    }

    public Syrup(String flavour){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = flavour; 
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public final String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
