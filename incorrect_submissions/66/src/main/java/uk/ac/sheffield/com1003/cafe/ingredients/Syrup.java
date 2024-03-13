package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;

    public Syrup(){
        this.amount = 10;
        this.flavour = "caramel";
    }

    public Syrup(String flavour, int amount){
        this.name = "Syrup";
        this.amount = amount;
        this.flavour = flavour;
        this.unit = Unit.ML;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
