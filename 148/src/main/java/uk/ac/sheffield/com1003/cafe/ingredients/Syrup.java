package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{

    private String flavor;

    public Syrup(){ this.amount = 10;}

    public Syrup(String flavor){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavor = flavor;
    }

    public String toString (){return "Syrup [unit =" + unit + ", amount =" + amount + ", flavor=" + flavor + "]";}
}
