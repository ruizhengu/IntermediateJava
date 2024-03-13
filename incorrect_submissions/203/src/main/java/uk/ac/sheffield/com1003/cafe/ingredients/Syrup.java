package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;
    // Syrup's constructor
    public Syrup(String flavour){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 100;
        this.flavour = "Caramel";
    }

    @Override
    public String toString(){

     return "Syrup [unit=" + unit + ", amount=" + amount + ",flavour=" + flavour + "]";
    }
}
