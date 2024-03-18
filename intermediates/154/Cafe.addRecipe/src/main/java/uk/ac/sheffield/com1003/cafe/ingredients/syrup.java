package uk.ac.sheffield.com1003.cafe.ingredients;

public class syrup extends Ingredient {
    private String flavour;
    
    public syrup(){
        this.unit = Unit.ML;
        this.flavour = "lime";
        this.amount = 30;
    }

    public syrup(String flavour){
        this.unit = Unit.ML;
        this.flavour = flavour;
        this.amount = 30;
    }

    @Override
     public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }
}
