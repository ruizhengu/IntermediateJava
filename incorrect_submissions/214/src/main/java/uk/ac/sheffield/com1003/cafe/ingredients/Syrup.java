package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;
    public Syrup(){
        this(6,"Maple");
    }
    public Syrup(String flavour){
        this(6,flavour);
    }
    public Syrup(int amount, String flavour){
        this.amount=amount;
        this.flavour=flavour;
        this.unit=Unit.ML;
    }

}
