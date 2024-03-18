package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavour;

    public Syrup(){
        this.amount = 20;
        this.unit = Unit.ML;
        this.flavour = "Guava";
    }
    public Syrup(String flavour){
        this();
        this.flavour = flavour;}
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour="+ flavour + "]";
    }
}
