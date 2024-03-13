package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;


    public Syrup(String flavour) {
        this.name = "Syrup" ;
        this.unit = Unit.ML;
        this.amount = 18;
        this.flavour = flavour;
    }

    //overloads the default constructor
    public Syrup(){
        this("Brown Sugar");
    }
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

}
