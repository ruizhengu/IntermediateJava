package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient{
    private String flavour;

    public Syrup() {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = 100;
        this.flavour = "Original";
    }

    public Syrup(int amount) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = "Original";
    }

    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;
        return name.equals(((Syrup)another).name) && amount == ((Syrup)another).amount && 
        flavour.equals(((Syrup)another).flavour) && unit.equals(((Syrup)another).unit);
    }
} 
