package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    //default constructor
    public Syrup(){
        this.flavour = "vanilla";
        this.unit = Unit.ML;
        this.amount = 25;
    }
    public Syrup(String flavour, int amount){
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return ("Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]");
    }
}
