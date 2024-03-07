package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavor;

    public Syrup(String flavor){
        this.flavor = flavor;
    }
    public Syrup(){
        this.flavor = "Vanilla";
        this.amount = 30;
        this.unit = Unit.ML;
    }
    public String toString(){
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavor=" + flavor + "]";
    }
}
