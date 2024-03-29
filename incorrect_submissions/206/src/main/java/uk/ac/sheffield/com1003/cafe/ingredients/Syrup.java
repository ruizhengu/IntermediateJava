package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;
    public Syrup(String flavour){
        this.flavour = flavour;
    }
    public Syrup(){
        this.flavour = "Strawberry";
        this.unit = Unit.ML;
        this.amount = 200;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
