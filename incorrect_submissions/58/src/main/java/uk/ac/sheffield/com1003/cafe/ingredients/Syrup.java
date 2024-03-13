package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() { this(50, "Maple"); }

    public Syrup(int amount) { this(amount, "Maple"); }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.unit = Unit.ML;
        this.amount = amount;
        this.flavour = flavour;
    }

    public String getFlavour() { return flavour; }

    @Override
    public String toString() { return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]"; }

    @Override
    public boolean equals(Object another) {
        if (another == null || ! (another instanceof Syrup))
            return false;

        Syrup other = (Syrup) another;
        return name.equals(other.getName()) &&
                amount == other.getAmount() &&
                unit == other.getUnit() &&
                flavour.equals(other.getFlavour());
    }
}
