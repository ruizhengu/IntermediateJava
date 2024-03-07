package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup(){
        this("Caramel");
    }

    public Syrup(String flavour){
        this(flavour,15);
    }

    public Syrup(String flavour,int amount){
        this.flavour = flavour;
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
    }
    public String getFlavour(){
        return flavour;
    }
    @Override
    public String toString(){
        return "Syrup [unit =" + unit + ", amount =" + amount + ", flavour" + flavour + "]";
    }
    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;
        return amount == ((Syrup)another).getAmount() && flavour == ((Syrup)another).getFlavour();
    }
}