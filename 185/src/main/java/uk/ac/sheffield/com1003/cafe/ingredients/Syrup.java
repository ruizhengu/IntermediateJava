package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;
    public Syrup(){this(50,"banana");}

    public Syrup(int amount){
        this(amount,"banana");
    }
    public Syrup(String flavour){
        this(50,flavour);
    }
    public Syrup(int amount,String flavour){
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit +", amount+" + amount + ", flavour=" + flavour + "]";
    }
}
