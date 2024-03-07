package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    // constructor for the Syrup
    public Syrup(String flavour) {
        unit = Unit.ML;
        amount = 10;
        flavour = ("Vanilla");
    }

    @Override
    public String toString() {
        return ("Syrup [unit= " + unit + ", amount= " + amount + ", flavour= " + flavour + "]");
        
    }

}
