package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this.name = "Syrup";
        unit = Unit.ML;
        amount = 50;
        flavour = "banana";
    }

    public Syrup(int amount) {
        this.name = "Syrup";
        unit = Unit.ML;
        this.amount = amount;
        this.flavour = "cherry";
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String getFlavour() {
        return this.flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Ingredient))
            return false; 
        if (name.equals(((Ingredient)another).getName()) && amount == (((Ingredient)another).getAmount())) {
            if (unit == (((Ingredient)another).getUnit()) && flavour == (((Syrup)another).getFlavour())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
