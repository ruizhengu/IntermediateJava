package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;
    private Unit unit;
    private int amount;

    public Syrup(){
        this.flavour = "Strawberry";
        this.unit = Unit.ML;
        this.amount = 30;
    }
    public Syrup(String flavour){
        this.flavour = flavour;
        this.unit = Unit.ML;
        this.amount = 30;
    }

    public String toString(){
        return "Syrup [unit=" + unit + ", amount=" + amount + ", " +
                "flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false;
        return (name.equals(((Ingredient)another).getName())) &&
                (((Syrup)another).amount == amount) &&
                (((Syrup)another).flavour.equals(flavour));
    }

}
