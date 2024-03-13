package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {

    private String flavour;

    public Syrup() {
        this.unit = Unit.ML;
        this.amount = 5;
    }

    public Syrup(String flavour) {
        this.flavour = flavour;
    }
    public boolean equals(Syrup syrup) {
        if (syrup.amount == this.amount) {
            if (syrup.unit == this.unit) {
                if (syrup.flavour == this.flavour) {
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";

    }
}

