package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour = "Caramel";

    public Syrup() {
        this("Caramel");
    }

    public Syrup(String flavour) {
        this(flavour, 5);
    }

    public Syrup(int amount) {
        this("Caramel", amount);
    }

    public Syrup(int amount, String flavour) {
        this(flavour, amount);
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

    public boolean equals(Syrup another) {
        if (another == null || ! (another instanceof Syrup))
            return false;
        return this.toString().equals(((Syrup)another).toString());
    }
}
