package uk.ac.sheffield.com1003.cafe.ingredients;

public class Syrup extends Ingredient {
    private String flavour;

    public Syrup() {
        this(5, "Vanilla");
    }

    public Syrup(String flavour) {
        this(5, flavour);
    }

    public Syrup(int amount, String flavour) {
        this.name = "Syrup";
        this.amount = amount;
        this.unit = Unit.ML;
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Syrup [unit=" + unit + ", amount=" + amount + ", flavour=" + flavour + "]";
    }

    @Override
    public boolean equals(Object other) {
        // Same name, unit, amount and instance
        if (!super.equals(other)) { return false; }
        Syrup otherObj = (Syrup) other;
        // Compare Specific instance
        return this.flavour.equals(otherObj.flavour);
    }
}
