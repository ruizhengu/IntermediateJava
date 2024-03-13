package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    // Default constructor
    public Syrup(){
        this.unit = Unit.ML;
        this.amount = 100;
        this.flavour = "Sour";
    }

    // Overloaded Constructor
    public Syrup (String flavour){
        this();
        this.flavour = flavour;
    }

    // Overridden toString() method
    public String toString(){
        return "Syrup [unit=" + this.unit + ", amount=" + this.amount + ", flavour=" + this.flavour + "]";
    }
}
