package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(){
        this.flavour = "caramel";
        this.amount = 100;
        this.unit = Unit.ML;
    }
    public Syrup(String flavour){
        this.flavour = flavour;
        this.amount = 100;
        this.unit = Unit.ML;
    }
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
