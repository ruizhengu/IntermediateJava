package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup(){
        this.name = "Syrup";
        this.unit = unit.ML;
        this.amount = 2;
        this.flavour = "Maple";
    }

    public Syrup(String flavour){
        this.name = "Syrup";
        this.unit = unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String getFlavour() {
        return this.flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit =" + unit + "amount =" + amount + "flavour =" + flavour + "]";
    }
}
