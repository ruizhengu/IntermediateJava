package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;

    public Syrup() { //default constructor if no parameters are given
        this.flavour = "Hazelnut";
        this.unit = Unit.ML;
        this.amount = 30;

    }
    public Syrup(String flavour) {
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
