package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    public String flavour;

    /*constructor that sets the default amount to 15ml and flavour to Vanilla*/
    public Syrup() {this(15, "Vanilla");}

    /*constructor that sets the amount to a given parameter and the flavour to Vanilla*/
    public Syrup(int amount) {this(amount, "Vanilla");}

    /*constructor that sets both the amount and flavour to given parameters*/
    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", type=" + flavour + "]";
    }
}
