package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(){
        this.unit = Unit.ML;
        this.amount = 10;
        this.flavour = "vanilla"; //default constructor
    }

    public Syrup(String flavour){
        this.flavour = flavour; //choose flavour constructor
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]"; //prints syrup details
    }
}