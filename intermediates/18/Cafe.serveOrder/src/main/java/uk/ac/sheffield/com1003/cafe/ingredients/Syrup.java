package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;

    public Syrup (String flavour){
        this.flavour = flavour;
        this.amount = 1000;
        this.unit = Unit.ML;
    }

    public Syrup(){
        this.flavour = "Salty";
        this.amount = 1000;
        this.unit = Unit.ML;
    }

    @Override
    public String toString(){
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
