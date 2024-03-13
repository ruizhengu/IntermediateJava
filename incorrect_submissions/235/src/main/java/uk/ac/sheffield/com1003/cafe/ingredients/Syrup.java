package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup() {
        this.flavour = "Caramel";
        this.amount = 10;
        this.unit = Unit.ML;
    }

    public Syrup(String flavour) {
        //overloaded constructor
        this.flavour = flavour;
        this.amount = 10;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        //overrides toString from Ingredient superclass
        return ("Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]");
    }
}
