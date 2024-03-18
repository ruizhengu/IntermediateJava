package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;

    public Syrup(String flavour) { // flavour is taken as input argument to a constructor
        this.unit = Unit.ML;
        this.amount = 30; // Putting just random Default amount;
        this.flavour = flavour;
    }
    // Default constructor
    public Syrup() {
        this.unit = Unit.ML;
        this.amount = 30; // Putting just random Default amount;
        this.flavour = "Vanilla"; // Default flavour; you can choose another value if you like
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}