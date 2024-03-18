package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour; 

    //this is a default constructor that sets the default amount to 15 and unit to ML and flavour to Chocolate 
    public Syrup() {
        this.flavour = "Chocolate";
        this.amount = 15;
        this.unit = Unit.ML;    
    }
   // this is a constructor that takes flavour as an argument 
    public Syrup(String flavour) {
        this.flavour = flavour;
        this.amount = 10;
        this.unit = Unit.ML;     
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
    
}
