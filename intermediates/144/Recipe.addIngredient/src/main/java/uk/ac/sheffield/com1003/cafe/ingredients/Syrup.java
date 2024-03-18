package uk.ac.sheffield.com1003.cafe.ingredients;
public class Syrup extends Ingredient {
    private String flavour;

    //constructor to implement the flavour of the syrup with the rest remaining as default values
    public Syrup(String flavour) {
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = 50;
    }
    //default values of syrup class if no parameters are given
    public Syrup() {
        this.flavour = "chocalate";
        this.unit = Unit.ML;
        this.amount = 50;
    }

    public String getFlavour() {
        return this.flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}