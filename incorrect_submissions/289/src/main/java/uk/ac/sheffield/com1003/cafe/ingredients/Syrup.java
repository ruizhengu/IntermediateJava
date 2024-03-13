package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;
    public String name;

    public Syrup(String flavour){
        this.flavour = flavour;
        this.name = "Syrup";
    }
    public Syrup(String flavour, int amount){
        this.flavour = flavour;
        this.amount = amount;
        this.name = "Syrup";
    }
    public Syrup(String flavour, int amount, Unit unit){
        this.flavour = flavour;
        this.amount = amount;
        this.unit = unit;
        this.name = "Syrup";
    }

    @Override
    public String toString(){
        return "Syrup [unit={" + unit + "}, "  + "amount={" +amount + "}," + " flavour={" + flavour + "}]";
    }
    
}
