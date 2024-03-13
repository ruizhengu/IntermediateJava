package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;
    public Syrup() {
        this.unit = Unit.ML;
        this.amount = 20;
        this.flavour = "Strawberry";
    }
    public Syrup(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
        }

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Syrup))
            return false;
        return this.unit.equals(((Syrup)another).getUnit()) &&
                this.amount == (((Syrup)another).getAmount()) &&
                this.flavour.equals(((Syrup)another).flavour);
    }
}
