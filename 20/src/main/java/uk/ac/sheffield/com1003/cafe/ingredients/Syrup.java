package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.flavour = "chocolate";
        this.amount = 8;
    }

    public Syrup(String flavour) {
        this.name = "Syrup";
        this.amount = 8;
        this.unit = Unit.ML;
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
        return name.equals(((Syrup)another).getName()) && amount == (((Syrup)another).getAmount()) && unit == (((Syrup)another).getUnit()) && flavour == (((Syrup)another).flavour);
    }
}

