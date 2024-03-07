package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup(){
        this("toffee");
    }

    public Syrup(String flavour){
        this.flavour=flavour;
        unit=Unit.ML;
        amount=40;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
