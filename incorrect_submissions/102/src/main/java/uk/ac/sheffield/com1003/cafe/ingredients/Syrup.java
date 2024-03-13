package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;
    private Unit unit = Unit.ML;
    private int amount = 10;

    public Syrup() {
        this.name = "Vanilla Syrup";
        this.flavour = "Vanilla";
    }

    public Syrup(String flavour) {
        this.name = flavour + " Syrup";
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object otherSyrup) {
        if (otherSyrup instanceof Syrup && flavour.equals(((Syrup)otherSyrup).flavour) && unit.equals(((Syrup)otherSyrup).unit))
            return true;
        else 
            return false;
    }
}
