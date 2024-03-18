package uk.ac.sheffield.com1003.cafe.ingredients;


public class Syrup extends Ingredient{

    //task 6
    private String flavour;


    public Syrup() {
        this("Spicy");
       }


    public Syrup(String flavour){

        this(flavour,100);
    }


    public Syrup(String flavour, int amount){

        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = flavour;
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Syrup [unit=" +unit + ", amount=" +amount + ", flavour=" + flavour + "]";
    }



}
