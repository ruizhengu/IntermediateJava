package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this("Maple", 30);
    }

    public Syrup(String flavour) {
        this(flavour, 30);
    }

    public Syrup(String flavour, int amount) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour +"]";
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;

        Syrup other = (Syrup) another;

        if (other.getUnit() != getUnit()) {
            return false;
        }

        if (other.getAmount() != getAmount()) {
            return false;
        }

        if (other.getFlavour() != getFlavour()) {
            return false;
        }

        return true;
    }
}
