package uk.ac.sheffield.com1003.cafe.ingredients;

/**
 * @author milan
 */
public class Syrup extends Ingredient {

    private String flavour;
    public Syrup (String flavour) { //constructor
        this.flavour = flavour;
    }
    public Syrup() { //default constructor which has attributes set to default
        this.flavour = "Chocolate";
        this.unit = Unit.ML;
        this.amount = 10;
    }

    @Override //overridden toString method -- prints different variables to other ingredient methods
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
